package com.vetclinic.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PinAndIdValidation implements ConstraintValidator<FourDigit, Integer> {
    @Override
    public void initialize(FourDigit constraintAnnotation) {

    }

    @Override
    public boolean isValid(Integer number, ConstraintValidatorContext constraintValidatorContext) {
        return String.valueOf(number).length() == 4;
    }
}
