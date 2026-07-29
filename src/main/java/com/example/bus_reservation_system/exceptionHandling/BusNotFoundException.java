package com.example.bus_reservation_system.exceptionHandling;

public class BusNotFoundException extends RuntimeException{
    public BusNotFoundException(String message){
        super(message);
    }
}
