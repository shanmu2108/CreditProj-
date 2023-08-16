package com.boot.restapi.RestAPIdemo.exception;

public class RecordExistsException extends Exception{
    public RecordExistsException(String message) {
        super(message);
    }
}
