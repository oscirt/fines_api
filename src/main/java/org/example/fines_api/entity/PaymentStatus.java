package org.example.fines_api.entity;

public enum PaymentStatus {
    DONE, // оплата прошла успешно
    IN_PROCESS, // в процессе обработки оплаты
    CANCELED, // отменено пользователем
    WAITING_PAYMENT // ожидание оплаты
}
