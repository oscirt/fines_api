package org.example.fines_api.repository;

import org.example.fines_api.entity.Fine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Репозиторий штрафов
 */
@Repository
public interface FineRepository extends JpaRepository<Fine, Integer> {

}
