package com.example.bus_reservation_system.ExceptionHandling;

public class SeatAlreadyExistsException extends RuntimeException{
    public SeatAlreadyExistsException(String message){
        super(message);
    }
}
