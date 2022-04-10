package com.HCL.eCommerce.advice;
import java.util.Set;
import java.util.stream.Collectors;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.HCL.eCommerce.exception.ErrorMessage;
import com.HCL.eCommerce.exception.ExistingAccountException;
import com.HCL.eCommerce.exception.NoRecordsException;

@ControllerAdvice
@Component
public class AppControllerAdvice {

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<?> handleConstraintViolationExceptions (ConstraintViolationException ex) {
		Set<ConstraintViolation<?>> constraintViolations = ex.getConstraintViolations();
		return new ResponseEntity<>(new ErrorMessage(constraintViolations.stream()
				.map(constraintViolation -> constraintViolation.getMessage()).collect(Collectors.toList()).get(0)),
				HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NoRecordsException.class)
	public ResponseEntity<?> handleNoRecordsException(NoRecordsException ex) {
		return new ResponseEntity<>(new ErrorMessage(ex.getMessage()), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ExistingAccountException.class)
	public ResponseEntity<?> handleExistingAccountException(ExistingAccountException ex) {
		return new ResponseEntity<>(new ErrorMessage(ex.getMessage()), HttpStatus.NOT_ACCEPTABLE);
	}
}
