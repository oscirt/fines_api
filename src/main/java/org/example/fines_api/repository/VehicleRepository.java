package org.example.fines_api.repository;

import org.example.fines_api.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Репозиторий транспорта
 */
@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {

}
