package org.example.fines_api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;

    @Column(name = "user_name", nullable = false)
    private String username;

    @Column(name = "user_phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "user_birth_date", nullable = false)
    private Date birthDate;

    @Column(name = "user_login", nullable = false, unique = true)
    private String login;

    @Column(name = "user_password", nullable = false, unique = true)
    private String password;

    @Column(name = "user_license", nullable = false, unique = true)
    private String license;
}
