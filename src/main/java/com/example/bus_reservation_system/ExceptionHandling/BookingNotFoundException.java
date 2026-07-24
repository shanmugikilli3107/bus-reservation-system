package com.example.bus_reservation_system.ExceptionHandling;

public class BookingNotFoundException extends RuntimeException{
    public BookingNotFoundException(String message){
        super(message);
    }
}
