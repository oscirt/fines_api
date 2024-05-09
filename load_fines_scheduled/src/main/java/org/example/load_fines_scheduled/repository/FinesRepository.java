package org.example.load_fines_scheduled.repository;

import org.example.load_fines_scheduled.entity.Fine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FinesRepository extends JpaRepository<Fine, Integer> {

    @Query(value = "SELECT * FROM fine f WHERE ?1 < f.fine_id", nativeQuery = true)
    List<Fine> checkForNewFines(Integer oldId);
}
