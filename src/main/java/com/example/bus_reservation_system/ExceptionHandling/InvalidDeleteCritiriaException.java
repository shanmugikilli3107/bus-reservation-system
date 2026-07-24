package com.example.bus_reservation_system.ExceptionHandling;

public class InvalidDeleteCritiriaException extends RuntimeException{
    public InvalidDeleteCritiriaException(String message){
        super(message);
    }
}
