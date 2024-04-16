package org.example.fines_api.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Vehicle")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicle_id")
    public int id;

    @Column(name = "vehicle_vin_number", nullable = false)
    public String vinNumber;

    @Column(name = "vehicle_brand", nullable = false)
    public String vehicleBrand;

    @Column(name = "vehicle_number", nullable = false)
    public String vehicleNumber;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id", nullable = false)
    public User user;
}
