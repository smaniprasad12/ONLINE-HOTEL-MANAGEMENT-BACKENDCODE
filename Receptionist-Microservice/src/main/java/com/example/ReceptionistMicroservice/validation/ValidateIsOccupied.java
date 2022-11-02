package com.example.ReceptionistMicroservice.validation;

import javax.validation.Constraint;
import javax.validation.Payload;

import java.lang.annotation.*;
//where you implements this validation
@Target({ElementType.FIELD,ElementType.PARAMETER})
//what time you use this validation
@Retention(RetentionPolicy.RUNTIME)

@Documented
//where you return logic for this validation
@Constraint(validatedBy = IsOccupiedValidator.class)
public @interface ValidateIsOccupied {

    String message() default "{ input should be Avaliable or Booked only}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
