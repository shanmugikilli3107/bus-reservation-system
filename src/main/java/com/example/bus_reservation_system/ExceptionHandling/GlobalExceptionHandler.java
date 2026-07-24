package com.example.bus_reservation_system.ExceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusNotFoundException.class)
    public ResponseEntity<?> handleBusNotFound(BusNotFoundException ex){
        ErrorResponse errorResponse=new ErrorResponse(ex.getMessage(),HttpStatus.NOT_FOUND.value(), LocalDateTime.now());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(BookingNotFoundException.class)
    public ResponseEntity<?> handleBookingNotFound(BookingNotFoundException ex){
        ErrorResponse errorResponse=new ErrorResponse(ex.getMessage(),HttpStatus.NOT_FOUND.value(),LocalDateTime.now());
        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(SeatAlreadyExistsException.class)
    public ResponseEntity<?> handleSeatAlreadyExists(SeatAlreadyExistsException ex){
        ErrorResponse errorResponse=new ErrorResponse(ex.getMessage(),HttpStatus.CONFLICT.value(), LocalDateTime.now());
      return new ResponseEntity<>(errorResponse,HttpStatus.CONFLICT)  ;
    }

    @ExceptionHandler(InvalidDeleteCritiriaException.class)
    public ResponseEntity<?> handleDeleteCritiria(InvalidDeleteCritiriaException ex){
        ErrorResponse errorResponse=new ErrorResponse(ex.getMessage(),HttpStatus.BAD_REQUEST.value(), LocalDateTime.now());
        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }
}
