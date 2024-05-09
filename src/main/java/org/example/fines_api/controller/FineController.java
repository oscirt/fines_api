package org.example.fines_api.controller;

import lombok.RequiredArgsConstructor;
import org.example.fines_api.dto.fine.FineDto;
import org.example.fines_api.mapper.FineMapper;
import org.example.fines_api.service.FineService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Контроллер работы со штрафами
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/fines")
public class FineController {

    /**
     * Сервис по работе с данными штрафов
     */
    private final FineService fineService;

    /**
     * Получение всех штрафов
     * @return список штрафов
     */
    @GetMapping
    public List<FineDto> getAllFines() {
        return FineMapper.toDto(fineService.getAllFines());
    }

    /**
     * Получение штрафа по id
     * @param fineId id штрафа
     * @return штраф
     */
    @GetMapping("/{fineId}")
    public FineDto getFineById(@PathVariable Integer fineId) {
        return FineMapper.toDto(fineService.getFineById(fineId));
    }

    /**
     * Удаление штрафа из бд
     * @param fineId id штрафа
     */
    @DeleteMapping("/{fineId}")
    public void deleteFine(@PathVariable Integer fineId) {
        fineService.deleteFineById(fineId);
    }
}
