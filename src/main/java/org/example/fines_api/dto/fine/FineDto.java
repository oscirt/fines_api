package org.example.fines_api.dto.fine;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.fines_api.dto.validation.OnCreate;
import org.example.fines_api.dto.validation.OnUpdate;
import org.example.fines_api.entity.enums.FineStatus;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FineDto {

    @NotNull(message = "Id must be not null.", groups = OnUpdate.class)
    private Integer id;

    private Integer userId;

    private Integer number;

    @Length(min = 9, max = 9, message = "Vehicle number length must be equals 9 symbols.", groups = { OnCreate.class, OnUpdate.class })
    private String vehicleNumber;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime startDate;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime endDate;

    private FineStatus status;

    private BigDecimal amount;

    @Length(max = 20, message = "Requisites length must be less than 20 symbols.", groups = { OnCreate.class, OnUpdate.class })
    private String requisites;
}
