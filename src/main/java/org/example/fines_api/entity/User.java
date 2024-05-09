package org.example.fines_api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer id;

    @Column(name = "user_name")
    private String username;

    @Column(name = "user_phone_number", unique = true)
    private String phoneNumber;

    @Column(name = "user_birth_date")
    private LocalDateTime birthDate;

    @Column(name = "user_login", unique = true)
    private String login;

    @Column(name = "user_password", unique = true)
    private String password;

    @Column(name = "user_license", unique = true)
    private String license;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Fine> fines;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Payment> payments;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Vehicle> vehicles;
}
