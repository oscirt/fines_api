package org.example.fines_api.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.fines_api.entity.Fine;
import org.example.fines_api.error.ResourceNotFoundException;
import org.example.fines_api.repository.FineRepository;
import org.example.fines_api.service.FineService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FineServiceImpl implements FineService {

    private final FineRepository fineRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Fine> getAllFines() {
        return fineRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Fine getFineById(Integer fineId) {
        Optional<Fine> optionalFine = fineRepository.findById(fineId);
        return optionalFine
                .orElseThrow(() -> new ResourceNotFoundException("Fine with id %d not found.".formatted(fineId)));
    }

    @Override
    @Transactional
    public Fine updateFine(Fine fine) {
        Fine fineFromDb = getFineById(fine.getId());
        fineFromDb.setFineAmount(fine.getFineAmount());
        fineFromDb.setFineNumber(fine.getFineNumber());
        fineFromDb.setFineRequisites(fine.getFineRequisites());
        fineFromDb.setFineStatus(fine.getFineStatus());
        fineFromDb.setFineStartDate(fine.getFineStartDate());
        fineFromDb.setFineEndDate(fine.getFineEndDate());
        fineFromDb.setFineVehicleNumber(fine.getFineVehicleNumber());
        fineFromDb.setUser(fine.getUser());
        return fine;
    }

    @Override
    @Transactional
    public Fine addFine(Fine fine) {
        return fineRepository.save(fine);
    }

    @Override
    @Transactional
    public void deleteFineById(Integer fineId) {
        fineRepository.deleteById(fineId);
    }
}
