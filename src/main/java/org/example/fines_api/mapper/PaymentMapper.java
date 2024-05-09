package org.example.fines_api.mapper;

import org.example.fines_api.dto.payment.PaymentDto;
import org.example.fines_api.entity.Payment;

import java.util.List;
import java.util.stream.Collectors;

public class PaymentMapper {

    public static PaymentDto toDto(Payment payment) {
        return new PaymentDto(
                payment.getId(),
                payment.getUser().getId(),
                payment.getPaymentNumber(),
                payment.getPaymentStatus(),
                payment.getPaymentDate(),
                payment.getPaymentAmount()
        );
    }

    public static List<PaymentDto> toDto(List<Payment> payments) {
        return payments.stream()
                .map(PaymentMapper::toDto)
                .collect(Collectors.toList());
    }

    public static Payment toEntity(PaymentDto dto) {
        return new Payment(
                dto.getId(),
                null,
                dto.getNumber(),
                dto.getStatus(),
                dto.getDate(),
                dto.getAmount()
        );
    }
}
