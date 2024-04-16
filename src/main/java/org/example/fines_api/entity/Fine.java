package org.example.fines_api.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "Fine")
public class Fine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fine_id")
    public int id;

    @Column(name = "fine_number")
    public int fineNumber;

    @Column(name = "fine_start_date")
    public Date fineStartDate;

    @Column(name = "fine_end_date")
    public Date fineEndDate;

//    @ElementCollection // todo: реализовать хранилище данных
//    public List<String> urls;

    @Column(name = "fine_requisites")
    public String fineRequisites;

    @Column(name = "fine_status")
    @Enumerated
    public FineStatus fineStatus;

    @Column(name = "fine_amount")
    public BigDecimal fineAmount;

    @Column(name = "fine_vehicle_number")
    public String fineVehicleNumber;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id", nullable = false)
    public User user;
}
