package com.example.bus_reservation_system.controller;

import com.example.bus_reservation_system.model.Booking;
import com.example.bus_reservation_system.service.BookingService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bookings")
public class BookingController {
    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;

    }

    @Operation(
            summary = "Create a booking",
            description = "Create a passenger booking for selected bus and seat"
    )
    @PostMapping()
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {
        return new ResponseEntity<Booking>(bookingService.createBooking(booking), HttpStatus.CREATED);
    }

    @Operation(
            summary = "Get a Booking by id",
            description = "Get a passenger booking by booking id"
    )
    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable Long id) {
        return new ResponseEntity<>(bookingService.getBookingById(id), HttpStatus.OK);
    }

    @Operation(
            summary = "Get a booking by bus id and seat number",
            description = "Get a passenger booking by bus id and seat number "
    )
    @GetMapping("/bus/{busId}/seat/{seatNumber}")
    public ResponseEntity<Booking> getBookingBySeatNumber(@PathVariable Long busId, @PathVariable String seatNumber) {
        return new ResponseEntity<>(bookingService.getBookingBySeatNumber(busId, seatNumber), HttpStatus.OK);
    }

    @Operation(
            summary = "get booking by passenger name",
            description = "Get a booking by your passenger Name"
    )
    @GetMapping("/PassengerName/{passengerName}")
    public ResponseEntity<List<Booking>> getBookingByPassengerName(@PathVariable String passengerName) {
        return new ResponseEntity<>(bookingService.getBookingByPassengerName(passengerName), HttpStatus.OK);
    }

    @Operation(
            summary = "get all a booking",
            description = "Get all the bookings of all bus"
    )
    @GetMapping()
    public ResponseEntity<List<Booking>> getAllBookings() {
        return new ResponseEntity<>(bookingService.getAllBooking(), HttpStatus.OK);
    }

    @Operation(
            summary = "Get all bookings",
            description = "Get all the booking by bus id"
    )
    @GetMapping("/BusId/{id}")
    public ResponseEntity<List<Booking>> getAllBookingByBusId(@PathVariable Long id) {
        return new ResponseEntity<>(bookingService.getAllBookingByBusId(id), HttpStatus.OK);
    }

    @Operation(
            summary = "update seat number by id",
            description = "update seat number of booking by bus id"
    )
    @PutMapping("/{id}")
    public ResponseEntity<Booking> updateSeatNumber(@PathVariable Long id, @RequestBody Booking updateBooking) {
        return new ResponseEntity<>(bookingService.updateBooking(id, updateBooking), HttpStatus.OK);
    }

    @Operation(
            summary = "delete booking",
            description = "delete all the bookings either by booking id or by seat number nad bus id"
    )
    @DeleteMapping("/deleteBooking")
    public ResponseEntity<String> deleteBooking(@RequestParam(required = false) Long id, @RequestParam(required = false) String seatNumber, @RequestParam(required = false) Long busId) {
        bookingService.deleteBooking(id, seatNumber, busId);
        return ResponseEntity.ok("Booking deleted successfully");
    }

}
