package com.example.bus_reservation_system.service;

import com.example.bus_reservation_system.model.Bus;
import com.example.bus_reservation_system.exceptionHandling.BusNotFoundException;
import com.example.bus_reservation_system.repository.BusRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusService {

    private BusRepository busRepository;
    public BusService(BusRepository busRepository){
        this.busRepository=busRepository;
    }

    //Add new bus into bus list
    public Bus createBus(Bus bus) {
        return busRepository.save(bus);
    }

    //Get all buses
    public List<Bus> getAllBuses() throws BusNotFoundException{
        List<Bus> buses = busRepository.findAll();
        return buses;
    }

    // Get bus details from the database by id
    public Bus getBusById(Long id) {
        return busRepository.findById(id).orElseThrow(() -> new BusNotFoundException("Bus not found for id :"+id));
    }

    //Get bus details from database by bus no
    public Bus getBusByBusNo(int busNo) {
        return busRepository.findByBusNo(busNo).orElseThrow(() -> new BusNotFoundException(busNo + " bus is not exists"));
    }

    // Get buses details from database if it is ac
    public List<Bus> getBusByAc(String acBus) {
        List<Bus> buses = busRepository.findByAcBus(acBus);
        if (buses.isEmpty()) {
            throw new BusNotFoundException("Ac Bus Not Found");
        }
        return buses;
    }
    // update the existing bus

    public Bus updateBus( Long id,Bus bus) {
        Bus existingBus=busRepository.findById(id).orElseThrow(()->new BusNotFoundException("Bus Not Found"));
        existingBus.setBusNo(bus.getBusNo());
        existingBus.setBusName(bus.getBusName());
        existingBus.setAcBus(bus.getAcBus());
        existingBus.setTotalSeats(bus.getTotalSeats());
        return busRepository.save(existingBus);
    }

    //deleting the bus detail by id
    public void deleteById(Long id) {

        Bus bus=busRepository.findById(id).orElseThrow(()->new BusNotFoundException("Bus not found to delete "));
        busRepository.delete(bus);
    }

    //deleting entire bus
    public void deteleBus(Bus bus) {
        busRepository.delete(bus);
    }

}
