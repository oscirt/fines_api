package org.example.fines_api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.fines_api.entity.enums.FineStatus;

import java.math.BigDecimal;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "fine")
public class Fine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fine_id")
    private int id;

    @ManyToOne(targetEntity = User.class, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "fine_number")
    private int fineNumber;

    @Column(name = "fine_vehicle_number")
    private String fineVehicleNumber;

    @Column(name = "fine_start_date")
    private Date fineStartDate;

    @Column(name = "fine_end_date")
    private Date fineEndDate;

//    @ElementCollection // todo: реализовать хранилище данных
//    private List<String> urls;

    @Column(name = "fine_status")
    @Enumerated
    private FineStatus fineStatus;

    @Column(name = "fine_amount")
    private BigDecimal fineAmount;

    @Column(name = "fine_requisites")
    private String fineRequisites;
}
