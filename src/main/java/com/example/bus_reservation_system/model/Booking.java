package com.example.bus_reservation_system.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Booking {
    @Id
    @GeneratedValue
    private Long id;
    @NotBlank
    private String passengerName;
    @NotNull
    private Integer age;
    @NotBlank
    private String gender;
    @Email
    private String email;
    @NotBlank
    private String phone;
    @DateTimeFormat
    private LocalDate journeyDate;
    private String seatNumber;

    private String bookingStatus="Confirmed";
    @ManyToOne
    @JoinColumn(name="bus_id")
    private Bus bus;
}
