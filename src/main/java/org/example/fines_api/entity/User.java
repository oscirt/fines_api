package org.example.fines_api.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    public int id;

    @Column(name = "user_name", nullable = false)
    public String username;

    @Column(name = "user_birth_date", nullable = false)
    public Date birthDate;

    @Column(name = "user_phone_number", nullable = false)
    public String phoneNumber;

    @Column(name = "user_login", nullable = false, unique = true)
    public String login;

    @Column(name = "user_password", nullable = false, unique = true)
    public String password;

    @Column(name = "user_license", nullable = false, unique = true)
    public String license;

    @OneToMany(targetEntity = Vehicle.class, cascade = CascadeType.ALL)
    public List<Vehicle> vehicles;

    @OneToMany(targetEntity = Payment.class, cascade = CascadeType.ALL)
    public List<Payment> payments;

    @OneToMany(targetEntity = Fine.class, cascade = CascadeType.ALL)
    public List<Fine> fines;
}
