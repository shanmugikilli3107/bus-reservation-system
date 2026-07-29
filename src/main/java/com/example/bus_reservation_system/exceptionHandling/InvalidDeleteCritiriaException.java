package com.example.bus_reservation_system.exceptionHandling;

public class InvalidDeleteCritiriaException extends RuntimeException{
    public InvalidDeleteCritiriaException(String message){
        super(message);
    }
}
