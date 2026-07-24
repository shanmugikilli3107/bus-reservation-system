package com.example.bus_reservation_system.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
    @Column(unique = true,nullable = false)
    private Integer busNo;
    @NotNull
    private String busName;
    @NotNull
    private String acBus;

    private Integer totalSeats;


}
