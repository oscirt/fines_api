package org.example.fines_api.service;

import org.example.fines_api.entity.Fine;

import java.util.List;

/**
 * Интерфейс сервиса управления данными штрафов
 */
public interface FineService {

    /**
     * Получение всех штрафов
     * @return список штрафов
     */
    List<Fine> getAllFines();

    /**
     * Получение штрафа по id
     * @param fineId id штрафа
     * @return штраф
     */
    Fine getFineById(Integer fineId);

    /**
     * Обновление данных штрафа
     * @param fine штраф
     * @return обновленный штраф
     */
    Fine updateFine(Fine fine);

    /**
     * Добавление нового штрафа
     * @param fine штраф
     * @return добавленный штраф
     */
    Fine addFine(Fine fine);

    /**
     * Удаление штрафа по id
     * @param fineId id штрафа
     */
    void deleteFineById(Integer fineId);
}
