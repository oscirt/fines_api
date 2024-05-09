package org.example.fines_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Spring boot приложение
 */
@SpringBootApplication
@EnableTransactionManagement
public class FinesApiApplication {

    /**
     * Главный метод приложения
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        SpringApplication.run(FinesApiApplication.class, args);
    }

}
