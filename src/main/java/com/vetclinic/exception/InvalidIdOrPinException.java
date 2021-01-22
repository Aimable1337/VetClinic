package com.vetclinic.exception;

public class InvalidIdOrPinException extends RuntimeException{

    public InvalidIdOrPinException(String message){
        super(message);
    }

}
