package Talent.TalentStreamApplication.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;		

@Target({ ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = JobPostValidation.class) 
public @interface JobPostValidator {
	
	 String message() default "Invalid field";
	    Class<?>[] groups() default {};
	    Class<? extends Payload>[] payload() default {};
	
	

}
