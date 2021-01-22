package com.vetclinic.service;


import com.vetclinic.DTO.AppointmentViewDto;

import java.time.LocalDate;
import java.util.List;

public interface AppointmentViewer {

    List<AppointmentViewDto> viewDoctorsAppointments(int doctorId, LocalDate date);

}
