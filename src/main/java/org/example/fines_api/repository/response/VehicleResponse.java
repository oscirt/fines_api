package org.example.fines_api.repository.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehicleResponse implements ModelResponse {
    private int vehicleId;
    private int userId;
    private String vehicleNumber;
    private String vehicleBrand;
    private String vehicleVin;
}
