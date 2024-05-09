package org.example.fines_api.service;

import org.example.fines_api.entity.User;

import java.util.List;

/**
 * Интерфейс сервиса управления данными пользователей
 */
public interface UserService {

    /**
     * Получение всех пользователей
     * @return список пользователей
     */
    List<User> getAllUsers();

    /**
     * Получение пользователя по id
     * @param userId id пользователя
     * @return объект пользователя
     */
    User getUserById(Integer userId);

    /**
     * Обновление данных пользователя
     * @param user объект пользователя
     * @return обновленный объект пользователя
     */
    User updateUser(User user);

    /**
     * Добавление нового пользователя
     * @param user объект пользователя
     * @return добавленный объект пользователя
     */
    User addUser(User user);

    /**
     * Удаление пользователя по id
     * @param userId id пользователя
     */
    void deleteUserById(Integer userId);
}
