package org.example.load_fines_scheduled.scheduler;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Scheduler парсинга гибдд на наличие новых штрафов
 */
@Component
public class ParseGibddScheduler {

    private final KafkaTemplate<String, String> template;

    public ParseGibddScheduler(KafkaTemplate<String, String> template) {
        this.template = template;
    }

    /**
     * Метод поиска штрафов, запускается каждые 10 секундl
     */
    @Scheduled(fixedDelay = 10_000L)
    public void checkForNewFines() {
        template.send("test", "Hello world!");
    }
}
