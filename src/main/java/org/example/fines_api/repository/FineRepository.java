package org.example.fines_api.repository;

import org.example.fines_api.entity.Fine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FineRepository extends JpaRepository<Fine, Integer> {

}
