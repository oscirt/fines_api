package org.example.fines_api.controller;

import lombok.RequiredArgsConstructor;
import org.example.fines_api.dto.vehicle.VehicleDto;
import org.example.fines_api.mapper.VehicleMapper;
import org.example.fines_api.service.VehicleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vehicles")
@RequiredArgsConstructor
public class VehicleController {

    private final VehicleService vehicleService;

    @GetMapping
    public List<VehicleDto> getAllVehicles() {
        return VehicleMapper.toDto(vehicleService.getAllVehicles());
    }

    @GetMapping("/{vehicleId}")
    public VehicleDto getVehicleById(@PathVariable Integer vehicleId) {
        return VehicleMapper.toDto(vehicleService.getVehicleById(vehicleId));
    }

    @DeleteMapping("/{vehicleId}")
    public void deleteVehicle(@PathVariable Integer vehicleId) {
        vehicleService.deleteVehicleById(vehicleId);
    }
}
