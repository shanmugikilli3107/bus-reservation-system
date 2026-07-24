package com.example.bus_reservation_system.Service;

import com.example.bus_reservation_system.ExceptionHandling.BookingNotFoundException;
import com.example.bus_reservation_system.ExceptionHandling.BusNotFoundException;
import com.example.bus_reservation_system.ExceptionHandling.InvalidDeleteCritiriaException;
import com.example.bus_reservation_system.ExceptionHandling.SeatAlreadyExistsException;
import com.example.bus_reservation_system.Model.Booking;
import com.example.bus_reservation_system.Model.Bus;
import com.example.bus_reservation_system.Repository.BookingRepository;
import com.example.bus_reservation_system.Repository.BusRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;
    private final BusRepository busRepository;

    public BookingService(BookingRepository bookingRepository, BusRepository busRepository) {
        this.bookingRepository = bookingRepository;
        this.busRepository = busRepository;
    }

    //create new entry
    public Booking createBooking(Booking booking) {
        Long busId = booking.getBus().getId();

        Bus bus = busRepository.findById(booking.getBus().getId()).orElseThrow(() -> new BusNotFoundException("Bus not found"));
        boolean seatBooked = bookingRepository.existsByBusIdAndSeatNumber(busId, booking.getSeatNumber());
        if (seatBooked) {
            throw new SeatAlreadyExistsException(booking.getSeatNumber() + " is already booked");
        }
        booking.setBus(bus);

        return bookingRepository.save(booking);
    }

    //get the passenger booking by id
    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id).orElseThrow(() -> new BookingNotFoundException("Booking Not found"));
    }

    //get booking by seat number
    public Booking getBookingBySeatNumber(Long busId,String seatNumber) {
        return bookingRepository.findByBusIdAndSeatNumber(busId,seatNumber).orElseThrow(() -> new BookingNotFoundException("Booking Not found"));
    }

    //get the passenger booking by passenger name
    public List<Booking> getBookingByPassengerName(String passengerName) {
        return bookingRepository.findByPassengerName(passengerName);
    }

    //get all booking
    public List<Booking> getAllBooking() {
        List<Booking> bookings = bookingRepository.findAll();
        return bookings;
    }

    //updating the existing booking
    public Booking updateBooking(Long id, Booking updateBooking) {
        Booking existingBooking = bookingRepository.findById(id).orElseThrow(() -> new BookingNotFoundException("Booking not Found"));
        existingBooking.setSeatNumber(updateBooking.getSeatNumber());
        return bookingRepository.save(existingBooking);
    }

    //get all booking form the particular bus
    public List<Booking> getAllBookingByBusId(Long id) {
        return bookingRepository.findByBusId(id);
    }

    //delete booking by id,seatnumber
    public void deleteBooking(Long id, String seatNumber, Long busId) {
        if (id != null) {
            bookingRepository.deleteById(id);
        } else if (seatNumber != null && busId != null) {
            bookingRepository.deleteByBusIdAndSeatNumber(busId, seatNumber);
        } else throw new InvalidDeleteCritiriaException("Provide delete criteria");
    }
}
