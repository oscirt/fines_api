package org.example.load_fines_scheduled.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

/**
 * Конфигурация для kafka продюсера
 */
@Configuration
public class KafkaProducerConfig {

    @Bean
    public NewTopic topic() {
        return TopicBuilder.name("test")
                .partitions(10)
                .replicas(1)
                .build();
    }

//    @Bean
//    public ApplicationRunner runner(KafkaTemplate<String, String> template) {
//        return args -> template.send("topic1", "test");
//    }
}
