package org.example.fines_api.service;

import org.example.fines_api.entity.Vehicle;

import java.util.List;

/**
 * Интерфейс сервиса управления данными транспорта
 */
public interface VehicleService {

    /**
     * Получение всех транспортов
     * @return список транспортов
     */
    List<Vehicle> getAllVehicles();

    /**
     * Получение транспорта по id
     * @param vehicleId id транспорта
     * @return транспорт
     */
    Vehicle getVehicleById(Integer vehicleId);

    /**
     * Обновление данных транспорта
     * @param vehicle транспорт
     * @return обновленный транспорт
     */
    Vehicle updateVehicle(Vehicle vehicle);

    /**
     * Добавление нового транспорта
     * @param vehicle транспорт
     * @return добавленный транспорт
     */
    Vehicle addVehicle(Vehicle vehicle);

    /**
     * Удаление транспорта по id
     * @param vehicleId id транспорта
     */
    void deleteVehicleById(Integer vehicleId);
}
