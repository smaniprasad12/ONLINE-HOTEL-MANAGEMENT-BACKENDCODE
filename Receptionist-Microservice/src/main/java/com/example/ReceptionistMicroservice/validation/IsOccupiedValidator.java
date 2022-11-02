package com.example.ReceptionistMicroservice.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

public class IsOccupiedValidator implements ConstraintValidator<ValidateIsOccupied, String> {
    @Override
    public boolean isValid(String isoccupied, ConstraintValidatorContext context) {
        // I am created list to  store the values
        List<String> isOccupied = Arrays.asList("Avaliable", "Booked");
        //checking the value contains in the list or not
        return isOccupied.contains(isoccupied);
    }
}
