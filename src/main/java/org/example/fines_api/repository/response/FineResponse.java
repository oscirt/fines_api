package org.example.fines_api.repository.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.fines_api.entity.enums.FineStatus;

import java.math.BigDecimal;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FineResponse implements ModelResponse {
    private int fineId;
    private int userId;
    private int fineNumber;
    private String fineVehicleNumber;
    private Date fineStartDate;
    private Date fineEndDate;
    private FineStatus fineStatus;
    private BigDecimal fineAmount;
    private String fineRequisites;
}
