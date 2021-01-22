package com.vetclinic.repository;

import com.vetclinic.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

    List<Appointment> findAllByDoctorIdAndDate(int id, LocalDate date);

    boolean existsAppointmentByCustomerIdAndId(int customerId, int appointmentId);

}
