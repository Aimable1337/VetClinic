package com.vetclinic.service;

import com.vetclinic.DTO.CancelAppointmentDto;
import com.vetclinic.DTO.NewAppointmentDto;
import com.vetclinic.entity.Appointment;
import com.vetclinic.exception.DateNotFreeException;
import com.vetclinic.exception.InvalidIdOrPinException;
import com.vetclinic.exception.NotFoundException;
import com.vetclinic.repository.AppointmentRepository;
import com.vetclinic.repository.CustomerRepository;
import com.vetclinic.repository.DoctorRepository;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService {

    private final AppointmentRepository appointmentRepository;

    private final CustomerRepository customerRepository;

    private final DoctorRepository doctorRepository;

    public BookingServiceImpl(AppointmentRepository appointmentRepository, CustomerRepository customerRepository, DoctorRepository doctorRepository) {
        this.appointmentRepository = appointmentRepository;
        this.customerRepository = customerRepository;
        this.doctorRepository = doctorRepository;
    }

    @Override
    public int makeAppointment(NewAppointmentDto newAppointmentDTO) {
        if (isCustomerIdAndPinValid(newAppointmentDTO.getCustomerId(), newAppointmentDTO.getPin())) {
            if (isDateFree(newAppointmentDTO)) {
                Appointment appointment = newAppointmentDTO.toEntity(
                        doctorRepository.findById(newAppointmentDTO.getDoctorId()).orElseThrow(() -> new NotFoundException("We have no doctor with id: " + newAppointmentDTO.getDoctorId())),
                        customerRepository.findById(newAppointmentDTO.getCustomerId()).orElseThrow(() -> new NotFoundException("We have no customer with id: " + newAppointmentDTO.getCustomerId()))
                );
                appointmentRepository.save(appointment);
                return appointment.getId();
            } else {
                throw new DateNotFreeException("The selected appointment date or time is not free. Try again with another date or time.");
            }
        } else {
            throw new InvalidIdOrPinException("Invalid Id or Pin. Please try again.");
        }
    }

    @Override
    public void cancelAppointment(CancelAppointmentDto cancelAppointmentDto) {
        if (isCustomerIdAndPinValid(cancelAppointmentDto.getCustomerId(), cancelAppointmentDto.getPin())) {
            if (appointmentRepository.existsAppointmentByCustomerIdAndId(cancelAppointmentDto.getCustomerId(), cancelAppointmentDto.getAppointmentId())) {
                appointmentRepository.deleteById(cancelAppointmentDto.getAppointmentId());
            } else {
                throw new NotFoundException("We have no such appointment");
            }
        } else {
            throw new InvalidIdOrPinException("Invalid Id or Pin. Please try again.");
        }
    }

    @Override
    public boolean isDateFree(NewAppointmentDto newAppointmentDto) {
        return appointmentRepository.findAllByDoctorIdAndDate(newAppointmentDto.getDoctorId(), newAppointmentDto.getDate())
                .stream()
                .noneMatch(appointment ->
                                appointment.getStartTime().isBefore(newAppointmentDto.getStartTime()) && appointment.getEndTime().isAfter(newAppointmentDto.getStartTime())
                                ||
                                appointment.getStartTime().isBefore(newAppointmentDto.getStartTime().plusHours(1)) && appointment.getEndTime().isAfter(newAppointmentDto.getStartTime().plusHours(1))
                );
    }

    @Override
    public boolean isCustomerIdAndPinValid(int id, int pin) {
        return customerRepository.existsCustomerByIdAndPin(id, pin);
    }

}