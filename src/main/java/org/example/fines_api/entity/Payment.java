package org.example.fines_api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.fines_api.entity.enums.PaymentStatus;

import java.math.BigDecimal;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private int id;

    @ManyToOne(targetEntity = User.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "payment_number")
    private int paymentNumber;

    @Column(name = "payment_status", nullable = false)
    @Enumerated
    private PaymentStatus paymentStatus;

    @Column(name = "payment_date", nullable = false)
    private Date paymentDate;

    @Column(name = "payment_amount", nullable = false)
    private BigDecimal paymentAmount;
}
