package com.vetclinic.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PinAndIdValidation.class)
public @interface FourDigit {
    String message() default "Pin and Id must contain four digits.";
    Class<?>[] groups() default {};
    public abstract Class<? extends Payload>[] payload() default {};
}
