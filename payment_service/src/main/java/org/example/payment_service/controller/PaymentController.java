package org.example.payment_service.controller;

import lombok.RequiredArgsConstructor;
import org.example.payment_service.dto.FineDto;
import org.example.payment_service.service.QrGenService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/processPayment")
@RequiredArgsConstructor
public class PaymentController {

    private final QrGenService qrGenService;

    @GetMapping(produces = "image/png")
    public byte[] generateQrCodeByPaymentRequisite(@RequestBody FineDto fineDto) {
        return qrGenService.generate(fineDto);
    }
}
