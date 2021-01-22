package com.vetclinic.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = SundayValidation.class)
public @interface OpenHours {
    String message() default "We are open from 9:00 to 18:00. Remember that you need one hour for appointment.";
    Class<?>[] groups() default {};
    public abstract Class<? extends Payload>[] payload() default {};
}
