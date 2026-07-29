package com.example.bus_reservation_system.controller;

import com.example.bus_reservation_system.model.Bus;
import com.example.bus_reservation_system.service.BusService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/buses")
public class BusController {

    private final BusService busService;// it cannot be changed because it is final ,it is recommended
    public BusController(BusService busService){
        this.busService=busService;
    }

    @PostMapping()
    public ResponseEntity<Bus> createBus(@RequestBody Bus bus) {
        return new ResponseEntity<>(busService.createBus(bus), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<Bus>> getAllBuses() {
        return new ResponseEntity<>(busService.getAllBuses(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bus> getById(@PathVariable Long id) {
        return new ResponseEntity<>(busService.getBusById(id), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Bus> getByBusNo(@RequestParam("busNo") int busNo) {
        return new ResponseEntity<>(busService.getBusByBusNo(busNo), HttpStatus.OK);
    }

    @GetMapping("/acBus")
    public ResponseEntity<List<Bus>> getByAc(@RequestParam String acBus) {
        return new ResponseEntity<>(busService.getBusByAc(acBus), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bus> updateBus(@PathVariable Long id, @RequestBody Bus bus) {
        return new ResponseEntity<>(busService.updateBus(id, bus), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deteleByID(@PathVariable Long id) {
        busService.deleteById(id);
    }

}
