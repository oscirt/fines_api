package org.example.fines_api.repository.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.fines_api.entity.enums.PaymentStatus;

import java.math.BigDecimal;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaymentResponse implements ModelResponse {
    private int paymentId;
    private int userId;
    private int paymentNumber;
    private PaymentStatus paymentStatus;
    private Date paymentDate;
    private BigDecimal paymentAmount;
}
