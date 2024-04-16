package org.example.fines_api.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "Payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    public int id;

    @Column(name = "payment_number")
    public int paymentNumber;

    @Column(name = "payment_status", nullable = false)
    @Enumerated
    public PaymentStatus paymentStatus;

    @Column(name = "payment_date", nullable = false)
    public Date paymentDate;

    @Column(name = "payment_amount", nullable = false)
    public BigDecimal paymentAmount;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id", nullable = false)
    public User owner;
}
