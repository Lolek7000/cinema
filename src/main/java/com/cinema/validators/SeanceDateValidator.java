package com.cinema.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SeanceDateValidator implements ConstraintValidator<SeanceDateConstraint, String> {

   public void initialize(SeanceDateConstraint constraint) {

   }

   public boolean isValid(String obj, ConstraintValidatorContext context) {
      return false;
   }
}
