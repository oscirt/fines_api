package org.example.load_fines_scheduled;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Spring приложение загрузки штрафов по таймауту
 */
@SpringBootApplication
@EnableScheduling
public class LoadFinesScheduledApplication {

	/**
	 * Начальный метод сервиса
	 * @param args аргументы командной строки
	 */
	public static void main(String[] args) {
		SpringApplication.run(LoadFinesScheduledApplication.class, args);
	}

}
