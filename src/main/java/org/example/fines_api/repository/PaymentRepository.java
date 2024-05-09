package org.example.fines_api.repository;

import org.example.fines_api.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Репозиторий оплат
 */
@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {

}
