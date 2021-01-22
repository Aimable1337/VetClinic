package com.vetclinic.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class SundayValidation implements ConstraintValidator<NotSunday, LocalDateTime> {
    @Override
    public void initialize(NotSunday constraintAnnotation) {
    }

    @Override
    public boolean isValid(LocalDateTime localDateTime, ConstraintValidatorContext constraintValidatorContext) {
        return localDateTime.getDayOfWeek() != DayOfWeek.SUNDAY;
    }
}
