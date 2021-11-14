package com.aptech.springmvc.validation;

import java.lang.annotation.*;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = fieldMatchValidator.class)
@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
// @FieldMatch(first = "password", second = "matchingPassword", message = "The password fields must match")
public @interface FieldMatch {
	String message() default "The fields must match";
	String first();
	String second();
	
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
