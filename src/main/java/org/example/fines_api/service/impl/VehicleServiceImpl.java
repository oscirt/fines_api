package org.example.fines_api.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.fines_api.entity.Vehicle;
import org.example.fines_api.error.ResourceNotFoundException;
import org.example.fines_api.repository.VehicleRepository;
import org.example.fines_api.service.VehicleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Vehicle getVehicleById(Integer vehicleId) {
        return vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle with id %d is not found.".formatted(vehicleId)));
    }

    @Override
    @Transactional
    public Vehicle updateVehicle(Vehicle vehicle) {
        Vehicle dbVehicle = getVehicleById(vehicle.getId());
        dbVehicle.setVehicleNumber(vehicle.getVehicleNumber());
        dbVehicle.setVehicleBrand(vehicle.getVehicleBrand());
        dbVehicle.setVinNumber(vehicle.getVinNumber());
        dbVehicle.setUser(vehicle.getUser());
        return vehicleRepository.save(vehicle);
    }

    @Override
    @Transactional
    public Vehicle addVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @Override
    @Transactional
    public void deleteVehicleById(Integer vehicleId) {
        vehicleRepository.deleteById(vehicleId);
    }
}
