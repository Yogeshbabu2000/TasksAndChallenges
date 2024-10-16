package Talent.TalentStreamApplication.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;



@Target({ElementType.FIELD,ElementType.PARAMETER, ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueEmailValidation.class) 

public @interface UniqueEmailValidator {
	
	public String message() default "Invalid email address";
	public Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {}; 
	

}
