package com.example.bus_reservation_system.exceptionHandling;

public class BookingNotFoundException extends RuntimeException{
    public BookingNotFoundException(String message){
        super(message);
    }
}
