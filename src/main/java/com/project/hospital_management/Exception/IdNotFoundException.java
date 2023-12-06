package com.project.hospital_management.Exception;

public class IdNotFoundException extends RuntimeException {

    private String message;
    public IdNotFoundException() {
    }
    public IdNotFoundException(String message){
	super();
	this.message=message;
    }
    public String getMessage() {
        return message;
    }
}
