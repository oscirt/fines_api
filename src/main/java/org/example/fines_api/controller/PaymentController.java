package org.example.fines_api.controller;

import lombok.RequiredArgsConstructor;
import org.example.fines_api.dto.payment.PaymentDto;
import org.example.fines_api.mapper.PaymentMapper;
import org.example.fines_api.service.PaymentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @GetMapping
    public List<PaymentDto> getAllPayments() {
        return PaymentMapper.toDto(paymentService.getAllPayments());
    }

    @GetMapping("/{paymentId}")
    public Object getPaymentById(@PathVariable Integer paymentId) {
        return PaymentMapper.toDto(paymentService.getPaymentById(paymentId));
    }

    @DeleteMapping("/{paymentId}")
    public void deletePayment(@PathVariable Integer paymentId) {
        paymentService.deletePaymentById(paymentId);
    }
}
