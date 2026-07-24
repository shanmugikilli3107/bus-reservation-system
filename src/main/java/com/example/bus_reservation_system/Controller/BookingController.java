package com.example.bus_reservation_system.Controller;

import com.example.bus_reservation_system.Model.Booking;
import com.example.bus_reservation_system.Service.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bookings")
public class BookingController {
    private final BookingService bookingService;

    public BookingController (BookingService bookingService){
        this.bookingService=bookingService;

    }
    @PostMapping("/createBooking")
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking){
        return new ResponseEntity<Booking>(bookingService.createBooking(booking), HttpStatus.CREATED);
    }
    @GetMapping("/getBookingById/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable Long id){
        return new ResponseEntity<>(bookingService.getBookingById(id),HttpStatus.OK);
    }
    @GetMapping("/getBookingBySeatNumber/{busId}/{seatNumber}")
    public ResponseEntity<Booking> getBookingBySeatNumber(@PathVariable Long busId,@PathVariable String seatNumber){
        return new ResponseEntity<>(bookingService.getBookingBySeatNumber(busId,seatNumber),HttpStatus.OK);
    }
    @GetMapping("/getBookingByPassengerName/{passengerName}")
    public ResponseEntity<List<Booking>> getBookingByPassengerName(@PathVariable String passengerName){
        return new ResponseEntity<>(bookingService.getBookingByPassengerName(passengerName),HttpStatus.OK);
    }
    @GetMapping("/getAllBookings")
    public ResponseEntity<List<Booking>> getAllBooking(){
        return new ResponseEntity<>(bookingService.getAllBooking(),HttpStatus.OK);
    }
    @GetMapping("/getAllBookingsByBusId/{id}")
    public ResponseEntity<List<Booking>> getAllBookingByBusId(@PathVariable Long id){
        return new ResponseEntity<>(bookingService.getAllBookingByBusId(id),HttpStatus.OK);
    }
@PutMapping("/updateSeatNumber/{id}")
    public ResponseEntity<Booking> updateSeatNumber(@PathVariable Long id,@RequestBody Booking updateBooking){
        return new ResponseEntity<>(bookingService.updateBooking(id,updateBooking),HttpStatus.OK);
}
@DeleteMapping("/deleteBooking")
    public ResponseEntity<String> deleteBooking(@RequestParam(required = false) Long id, @RequestParam(required = false) String seatNumber,@RequestParam(required = false) Long busId){
        bookingService.deleteBooking(id,seatNumber,busId);
        return ResponseEntity.ok("Booking deleted successfully");
}

}
