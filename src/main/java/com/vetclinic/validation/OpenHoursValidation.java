package com.vetclinic.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class OpenHoursValidation implements ConstraintValidator<OpenHours, LocalDateTime> {
    @Override
    public void initialize(OpenHours constraintAnnotation) {
    }

    @Override
    public boolean isValid(LocalDateTime localDateTime, ConstraintValidatorContext constraintValidatorContext) {
        return localDateTime.toLocalTime().isAfter(LocalTime.of(9, 0)) && localDateTime.toLocalTime().isBefore(LocalTime.of(17, 0));
    }
}
