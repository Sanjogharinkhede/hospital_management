
package com.project.hospital_management.Exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.project.hospital_management.util.ResponseStructure;

@RestControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

    ResponseStructure<String> structure = new ResponseStructure<String>();

    @ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<ResponseStructure<String>> idNotFoundExceptionHandler(IdNotFoundException exception) {
	structure.setMessage("Id not found Exception");
	structure.setData(exception.getMessage());
	structure.setStatus(HttpStatus.NOT_FOUND.value());
	return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(NameNotFoundException.class)
    public ResponseEntity<ResponseStructure<String>> nameNotFoundExceptionHandler(NameNotFoundException exception) {
	structure.setMessage("name not found Exception");
	structure.setData(exception.getMessage());
	structure.setStatus(HttpStatus.NOT_FOUND.value());
	return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
	    HttpHeaders headers, HttpStatus status, WebRequest request) {

	List<ObjectError> errors = ex.getAllErrors();
	Map<String, String> map = new HashMap<String, String>();
	for (ObjectError objectError : errors) {
	    FieldError fieldError = (FieldError) objectError;
	    String name = fieldError.getField();
	    String message = fieldError.getDefaultMessage();
	    map.put(name, message);
	}
	return new ResponseEntity<Object>(map, HttpStatus.BAD_REQUEST);

    }
    
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ResponseStructure<String>> handleConstraintViolationException(ConstraintViolationException exception){
	structure.setMessage(exception.getMessage());
	structure.setStatus(HttpStatus.BAD_REQUEST.value());
	structure.setData("Database  Constraints are violated");
	return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.BAD_REQUEST);
    }
    
    
    
    
    

}
