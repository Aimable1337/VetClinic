package com.vetclinic.service;

import com.vetclinic.DTO.CancelAppointmentDto;
import com.vetclinic.DTO.NewAppointmentDto;

public interface BookingService {

    int makeAppointment(NewAppointmentDto newAppointmentDTO);

    void cancelAppointment(CancelAppointmentDto cancelAppointmentDto);

    boolean isDateFree(NewAppointmentDto newAppointmentDto);

    boolean isCustomerIdAndPinValid(int id, int pin);

}