package com.vetclinic.service;

import com.vetclinic.DTO.AppointmentViewDto;
import com.vetclinic.exception.NotFoundException;
import com.vetclinic.repository.AppointmentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppointmentViewerImpl implements AppointmentViewer{

    private final AppointmentRepository appointmentRepository;

    public AppointmentViewerImpl(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public List<AppointmentViewDto> viewDoctorsAppointments(int doctorId, LocalDate date) {
        List<AppointmentViewDto> appointments =  appointmentRepository.findAllByDoctorIdAndDate(doctorId, date)
                                                        .stream()
                                                        .map(AppointmentViewDto::new)
                                                        .collect(Collectors.toList());
        if (appointments.isEmpty())
            throw new NotFoundException("Doctor with id: " + doctorId + " has no any appointments on " + date);
        return appointments;
    }
}
