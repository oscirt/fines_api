package org.example.fines_api.mapper;

import org.example.fines_api.dto.vehicle.VehicleDto;
import org.example.fines_api.entity.Vehicle;

import java.util.List;
import java.util.stream.Collectors;

public class VehicleMapper {

    public static VehicleDto toDto(Vehicle vehicle) {
        return new VehicleDto(
                vehicle.getId(),
                vehicle.getUser().getId(),
                vehicle.getVehicleNumber(),
                vehicle.getVehicleBrand(),
                vehicle.getVinNumber()
        );
    }

    public static List<VehicleDto> toDto(List<Vehicle> fines) {
        return fines.stream()
                .map(VehicleMapper::toDto)
                .collect(Collectors.toList());
    }

    public static Vehicle toEntity(VehicleDto dto) {
        return new Vehicle(
                dto.getId(),
                null,
                dto.getNumber(),
                dto.getBrand(),
                dto.getVinNumber()
        );
    }
}
