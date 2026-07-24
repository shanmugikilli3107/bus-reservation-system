package com.example.bus_reservation_system.Repository;

import com.example.bus_reservation_system.Model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Long> {
    List<Booking>  findByBusId(Long id);
    boolean existsByBusIdAndSeatNumber(Long busId,String seatNumber);

    Optional<Booking> findByBusIdAndSeatNumber(Long busId,String seatNumber);
    List<Booking> findByPassengerName(String passengerName);

    void deleteByBusIdAndSeatNumber(Long busId,String seatNumber);




}
