package org.example.fines_api.controller;

import org.example.fines_api.entity.User;
import org.example.fines_api.entity.Vehicle;
import org.example.fines_api.error.ErrorResponse;
import org.example.fines_api.repository.mapper.ModelMapper;
import org.example.fines_api.repository.request.AddVehicleRequest;
import org.example.fines_api.service.ManageDataService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    private final ManageDataService manageDataService;

    public VehicleController(ManageDataService manageDataService) {
        this.manageDataService = manageDataService;
    }

    @GetMapping
    public List<Object> getAllVehicles() {
        return manageDataService.getAllVehicles().stream()
                .map(ModelMapper::mapModelToResponse)
                .collect(Collectors.toList());
    }

    @GetMapping("/{vehicleId}")
    public Object getVehicleById(@PathVariable Integer vehicleId) {
        return ModelMapper.mapModelToResponse(manageDataService.getVehicleById(vehicleId));
    }

    @PostMapping
    public Object addVehicle(@RequestBody AddVehicleRequest vehicleRequest) {
        User user = manageDataService.getUserById(vehicleRequest.getUserId());
        Object object = ModelMapper.mapAddRequestToResponse(vehicleRequest, user);
        if (object != null) {
            return ModelMapper.mapModelToResponse(manageDataService.addVehicle((Vehicle) object));
        }
        return new ResponseEntity<>(new ErrorResponse("User not found"), HttpStatusCode.valueOf(404));
    }

    // todo: НЕ РАБОТАЕТ
//    @PutMapping("/{vehicleId}")
//    public Object updateVehicle(@RequestBody Vehicle vehicle, @PathVariable Integer vehicleId) {
//        vehicle.setId(vehicleId);
//        return ModelMapper.mapModelToResponse(manageDataService.updateVehicle(vehicle));
//    }

    @DeleteMapping("/{vehicleId}")
    public void deleteVehicle(@PathVariable Integer vehicleId) {
        manageDataService.deleteVehicleById(vehicleId);
    }
}
