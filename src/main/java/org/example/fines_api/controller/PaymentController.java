package org.example.fines_api.controller;

import org.example.fines_api.entity.Payment;
import org.example.fines_api.entity.User;
import org.example.fines_api.error.ErrorResponse;
import org.example.fines_api.repository.mapper.ModelMapper;
import org.example.fines_api.repository.request.AddPaymentRequest;
import org.example.fines_api.service.ManageDataService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final ManageDataService manageDataService;

    public PaymentController(ManageDataService manageDataService) {
        this.manageDataService = manageDataService;
    }

    @GetMapping
    public List<Object> getAllPayments() {
        return manageDataService.getAllPayments().stream()
                .map(ModelMapper::mapModelToResponse)
                .collect(Collectors.toList());
    }

    @GetMapping("/{paymentId}")
    public Object getPaymentById(@PathVariable Integer paymentId) {
        return ModelMapper.mapModelToResponse(manageDataService.getPaymentById(paymentId));
    }

    @PostMapping
    public Object addPayment(@RequestBody AddPaymentRequest paymentRequest) {
        User user = manageDataService.getUserById(paymentRequest.getUserId());
        Object object = ModelMapper.mapAddRequestToResponse(paymentRequest, user);
        if (object != null) {
            return ModelMapper.mapModelToResponse(manageDataService.addPayment((Payment) object));
        }
        return new ResponseEntity<>(new ErrorResponse("User not found"), HttpStatusCode.valueOf(404));
    }

    // todo: НЕ РАБОТАЕТ
//    @PutMapping("/{paymentId}")
//    public Object updatePayment(@RequestBody Payment payment, @PathVariable Integer paymentId) {
//        payment.setId(paymentId);
//        return ModelMapper.mapModelToResponse(manageDataService.updatePayment(payment));
//    }

    @DeleteMapping("/{paymentId}")
    public void deletePayment(@PathVariable Integer paymentId) {
        manageDataService.deletePaymentById(paymentId);
    }
}
