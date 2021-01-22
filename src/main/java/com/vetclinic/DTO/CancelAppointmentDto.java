package com.vetclinic.DTO;

import com.vetclinic.validation.FourDigit;

public class CancelAppointmentDto {

    private int appointmentId;

    @FourDigit
    private int customerId;

    @FourDigit
    private int pin;

    public int getAppointmentId() {
        return appointmentId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getPin() {
        return pin;
    }

}
