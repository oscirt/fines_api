package org.example.fines_api.config;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.NewTopic;
import org.example.fines_api.entity.Fine;
import org.example.fines_api.entity.User;
import org.example.fines_api.entity.enums.FineStatus;
import org.example.fines_api.service.FineService;
import org.example.fines_api.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Configuration
@RequiredArgsConstructor
public class KafkaConsumerConfig {

    private final Pattern pattern = Pattern.compile("id=(.*), userId=(.*), fineNumber=(.*), fineVehicleNumber=(.*), " +
            "fineStartDate=(.*), fineEndDate=(.*), fineStatus=(.*), fineAmount=(.*), fineRequisites=(.*)\\)");

    private final UserService userService;
    private final FineService fineService;

    @Bean
    public NewTopic topic() {
        return TopicBuilder.name("fines")
                .partitions(10)
                .replicas(1)
                .build();
    }

    @KafkaListener(id = "new_fines_to_db_listener", topics = "fines")
    @Transactional
    public void listen(String in) {
        Matcher matcher = pattern.matcher(in);
        matcher.find();
        User user = userService.getUserById(Integer.parseInt(matcher.group(2)));
        Fine fine = new Fine(
                Integer.parseInt(matcher.group(1)),
                user,
                Integer.parseInt(matcher.group(3)),
                matcher.group(4),
                LocalDateTime.parse(matcher.group(5)),
                LocalDateTime.parse(matcher.group(6)),
                FineStatus.valueOf(matcher.group(7)),
                new BigDecimal(matcher.group(8)),
                matcher.group(9)
        );
        user.getFines().add(fine);
        fineService.addFine(fine);
    }
}
