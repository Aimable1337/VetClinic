package com.vetclinic.controller;

import com.vetclinic.DTO.AppointmentViewDto;
import com.vetclinic.DTO.CancelAppointmentDto;
import com.vetclinic.DTO.NewAppointmentDto;
import com.vetclinic.service.AppointmentViewer;
import com.vetclinic.service.BookingService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/appointments")
public class VetClinicController {

    private final AppointmentViewer appointmentViewer;

    private final BookingService bookingService;


    public VetClinicController(AppointmentViewer appointmentViewer, BookingService bookingService) {
        this.appointmentViewer = appointmentViewer;
        this.bookingService = bookingService;
    }

    @GetMapping("/doctor/{id}/{date}")
    public ResponseEntity<List<AppointmentViewDto>> showAppointmentsForDoctor(@PathVariable int id,
                                                                              @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date){
        return new ResponseEntity<>(
                appointmentViewer.viewDoctorsAppointments(id, date),
                HttpStatus.OK
        );
    }

    @PostMapping
    public ResponseEntity<String> makeAppointment(@Valid @RequestBody NewAppointmentDto newAppointmentDto){
        int id = bookingService.makeAppointment(newAppointmentDto);
        return new ResponseEntity<>(
                "Your appointment's id is: " + id + ". Please remember it or write it down",
                HttpStatus.CREATED
        );
    }

    @DeleteMapping
    public ResponseEntity<String> cancelAppointment(@Valid @RequestBody CancelAppointmentDto cancelAppointmentDto){
        bookingService.cancelAppointment(cancelAppointmentDto);
        return new ResponseEntity<>(
                "Appointment canceled.",
                HttpStatus.ACCEPTED
        );
    }
}
