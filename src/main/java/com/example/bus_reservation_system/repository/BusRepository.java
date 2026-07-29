package com.example.bus_reservation_system.repository;

import com.example.bus_reservation_system.model.Bus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BusRepository extends JpaRepository<Bus, Long> {
    Optional<Bus> findByBusNo(int busNo);


    List<Bus> findByAcBus(String acBus);

}
