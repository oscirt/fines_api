package org.example.load_fines_scheduled.scheduler;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.load_fines_scheduled.entity.Fine;
import org.example.load_fines_scheduled.entity.FineStatus;
import org.example.load_fines_scheduled.repository.FinesRepository;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Scheduler парсинга гибдд на наличие новых штрафов
 */
@Component
@RequiredArgsConstructor
public class ParseGibddScheduler {

    Logger logger = LogManager.getLogger();

    private final KafkaTemplate<String, String> template;
    private final FinesRepository finesRepository;

    private Integer latestIndex;
    private final Path path = Paths.get("load_fines_scheduled", "src", "main", "resources", "latestIndex.txt");

    @PostConstruct
    public void init() {
        try {
            latestIndex = Integer.parseInt(Files.readString(path));
        } catch (IOException e) {
            latestIndex = 0;
        }
    }

    /**
     * Метод поиска штрафов, запускается каждые 10 секунд
     */
    @Scheduled(fixedDelay = 10_000L)
    public void checkForNewFines() {
        List<Fine> fines = finesRepository.checkForNewFines(latestIndex);
        if (!fines.isEmpty()) {
            fines.forEach(fine -> template.send("fines", fine.toString()));
            latestIndex = fines.get(fines.size() - 1).getId();
            try {
                Files.write(path, latestIndex.toString().getBytes(),
                        StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            } catch (IOException e) {
                logger.error("Cannot write to file: %s".formatted(e));
            }
        }
    }

    @Scheduled(fixedDelay = 5_000L)
    public void generateNewFine() {
        Random random = new Random();
        Integer userId = random.nextInt(12, 16);
        String carNumber = switch (userId) {
            case 12 -> "A111AA11";
            case 13 -> "B222BB22";
            case 14 -> "C333CC33";
            case 15 -> "D444DD44";
            default -> "";
        };
        String requisite = random.ints(20, 0, 10)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining());
        logger.info(requisite);
        finesRepository.save(new Fine(
                0,
                userId,
                random.nextInt(0, Integer.MAX_VALUE),
                carNumber,
                LocalDateTime.now().minusDays(20),
                LocalDateTime.now().plusDays(20),
                FineStatus.NOT_PAID,
                BigDecimal.valueOf(random.nextLong(999999), 2),
                requisite
        ));
    }
}
