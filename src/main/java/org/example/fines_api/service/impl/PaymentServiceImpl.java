package org.example.fines_api.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.fines_api.entity.Payment;
import org.example.fines_api.error.ResourceNotFoundException;
import org.example.fines_api.repository.PaymentRepository;
import org.example.fines_api.service.PaymentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Payment getPaymentById(Integer paymentId) {
        return paymentRepository.findById(paymentId)
                .orElseThrow(() -> new ResourceNotFoundException("Payment with id %d not found.".formatted(paymentId)));
    }

    @Override
    @Transactional
    public Payment updatePayment(Payment payment) {
        Payment paymentFromDb = getPaymentById(payment.getId());
        paymentFromDb.setPaymentAmount(payment.getPaymentAmount());
        paymentFromDb.setPaymentDate(payment.getPaymentDate());
        paymentFromDb.setPaymentNumber(payment.getPaymentNumber());
        paymentFromDb.setPaymentStatus(payment.getPaymentStatus());
        paymentFromDb.setUser(payment.getUser());
        return payment;
    }

    @Override
    @Transactional
    public Payment addPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    @Transactional
    public void deletePaymentById(Integer paymentId) {
        paymentRepository.deleteById(paymentId);
    }
}
