package org.example.fines_api.service;

import org.example.fines_api.entity.Payment;

import java.util.List;

/**
 * Интерфейс сервиса управления данными платежей
 */
public interface PaymentService {

    /**
     * Получение всех платежей
     * @return список платежей
     */
    List<Payment> getAllPayments();

    Payment getPaymentById(Integer paymentId);

    /**
     * Обновление данных платежа
     * @param payment платеж
     * @return обновленный платеж
     */
    Payment updatePayment(Payment payment);

    /**
     * Добавление нового платежа
     * @param payment платеж
     * @return добавленный платеж
     */
    Payment addPayment(Payment payment);

    /**
     * Удаление штрафа по id
     * @param paymentId id штрафа
     */
    void deletePaymentById(Integer paymentId);
}
