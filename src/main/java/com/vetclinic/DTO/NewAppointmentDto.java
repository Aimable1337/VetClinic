package com.vetclinic.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vetclinic.entity.Appointment;
import com.vetclinic.entity.Customer;
import com.vetclinic.entity.Doctor;
import com.vetclinic.validation.FourDigit;
import com.vetclinic.validation.NotSunday;
import com.vetclinic.validation.OpenHours;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class NewAppointmentDto {

    @FourDigit
    @NotNull(message = "You have to provide your id")
    private int customerId;

    @FourDigit
    @NotNull(message = "You have to provide your pin")
    private int pin;

    @FourDigit
    @NotNull(message = "You have to provide doctor's id")
    private int doctorId;

    @FutureOrPresent(message = "You can't make appointment in past.")
    @NotSunday
    @OpenHours
    @NotNull(message = "Please tell us when you are going to visit our clinic")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateAndTime;

    public int getCustomerId() {
        return customerId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public int getPin() {
        return pin;
    }

    public LocalDate getDate() {
        return dateAndTime.toLocalDate();
    }

    public LocalTime getStartTime() {
        return dateAndTime.toLocalTime();
    }

    public Appointment toEntity(Doctor doctor, Customer customer){
        return new Appointment(0, customer, doctor, dateAndTime.toLocalDate(), dateAndTime.toLocalTime(), dateAndTime.toLocalTime().plusHours(1));
    }

}
