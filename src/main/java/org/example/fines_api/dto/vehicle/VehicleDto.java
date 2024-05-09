package org.example.fines_api.dto.vehicle;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.fines_api.dto.validation.OnCreate;
import org.example.fines_api.dto.validation.OnUpdate;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
public class VehicleDto {

    @NotNull(message = "Id must be not null.", groups = OnUpdate.class)
    private Integer id;

    private Integer userId;

    @Length(min = 8, max = 8, message = "Number length must be equals 8 symbols.", groups = { OnCreate.class, OnUpdate.class })
    private String number;

    @Length(max = 42, message = "Brand length must be less than 42 symbols.", groups = { OnCreate.class, OnUpdate.class })
    private String brand;

    @Length(min = 17, max = 17, message = "Vin number length must be equals 17 symbols.", groups = { OnCreate.class, OnUpdate.class })
    private String vinNumber;
}
