package com.vetclinic.DTO;

import com.vetclinic.entity.Appointment;

import java.time.LocalDate;
import java.time.LocalTime;

public class AppointmentViewDto {

    private int appointmentId;

    private int customerId;

    private int doctorId;

    private LocalDate date;

    private LocalTime startTime;

    private LocalTime endTime;

    public AppointmentViewDto(Appointment source){
        this.appointmentId = source.getId();
        this.customerId = source.getCustomer().getId();
        this.doctorId = source.getDoctor().getId();
        this.date = source.getDate();
        this.startTime = source.getStartTime();
        this.endTime = source.getEndTime();
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }
}
