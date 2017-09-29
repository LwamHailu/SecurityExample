package edu.mum.validator;

import java.time.LocalDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class YearValidator implements ConstraintValidator<YearConstraint, Integer>  {

	@Override
	public void initialize(YearConstraint year) {
		
	}

	@Override
	public boolean isValid(Integer year, ConstraintValidatorContext ctx) {
		
		int currentYear = LocalDate.now().getYear();
		return ( year!=null && year<=currentYear);
		
	}

}
