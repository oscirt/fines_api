package org.example.fines_api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "vehicle")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicle_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "vehicle_number", nullable = false)
    private String vehicleNumber;

    @Column(name = "vehicle_brand", nullable = false)
    private String vehicleBrand;

    @Column(name = "vehicle_vin_number", nullable = false)
    private String vinNumber;
}
