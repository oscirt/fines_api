package org.example.fines_api.controller;

import org.example.fines_api.entity.Fine;
import org.example.fines_api.entity.User;
import org.example.fines_api.error.ErrorResponse;
import org.example.fines_api.repository.mapper.ModelMapper;
import org.example.fines_api.repository.request.AddFineRequest;
import org.example.fines_api.service.ManageDataService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/fines")
public class FineController {

    private final ManageDataService manageDataService;

    public FineController(ManageDataService manageDataService) {
        this.manageDataService = manageDataService;
    }

    @GetMapping
    public List<Object> getAllFines() {
        return manageDataService.getAllFines().stream()
                .map(ModelMapper::mapModelToResponse)
                .collect(Collectors.toList());
    }

    @GetMapping("/{fineId}")
    public Object getFineById(@PathVariable Integer fineId) {
        return ModelMapper.mapModelToResponse(manageDataService.getFineById(fineId));
    }

    @PostMapping
    public Object addFine(@RequestBody AddFineRequest fineRequest) {
        User user = manageDataService.getUserById(fineRequest.getUserId());
        Object object = ModelMapper.mapAddRequestToResponse(fineRequest, user);
        if (object != null) {
            return ModelMapper.mapModelToResponse(manageDataService.addFine((Fine) object));
        }
        return new ResponseEntity<>(new ErrorResponse("User not found"), HttpStatusCode.valueOf(404));
    }

    // todo: НЕ РАБОТАЕТ
//    @PutMapping("/{fineId}")
//    public Object updateFine(@RequestBody Fine fine, @PathVariable Integer fineId) {
//        fine.setId(fineId);
//        return ModelMapper.mapModelToResponse(manageDataService.updateFine(fine));
//    }

    @DeleteMapping("/{fineId}")
    public void deleteFine(@PathVariable Integer fineId) {
        manageDataService.deleteFineById(fineId);
    }
}
