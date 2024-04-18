package org.example.fines_api.repository.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddVehicleRequest {
    private int userId;
    private String vinNumber;
    private String vehicleBrand;
    private String vehicleNumber;
}
