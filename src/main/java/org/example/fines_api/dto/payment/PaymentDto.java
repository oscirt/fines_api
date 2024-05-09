package org.example.fines_api.dto.payment;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.fines_api.dto.validation.OnUpdate;
import org.example.fines_api.entity.enums.PaymentStatus;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDto {

    @NotNull(message = "Id must be not null.", groups = OnUpdate.class)
    private Integer id;

    private Integer userId;

    private Integer number;

    private PaymentStatus status;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime date;

    private BigDecimal amount;
}
