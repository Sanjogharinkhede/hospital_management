package com.project.hospital_management.Exception;

public class NameNotFoundException extends RuntimeException {
    private String message;
    public NameNotFoundException() {
    }
    public NameNotFoundException(String message){
	super();
	this.message=message;
    }
    public String getMessage() {
        return message;
    }
}
