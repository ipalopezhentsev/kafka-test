package de.iliks

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component
import java.time.Instant

@Component
class SpringKafkaPublisher(
    private val kafkaTemplate: KafkaTemplate<String, String>,
    @Value("\${kafka.topic}")
    private val topicName: String
): ApplicationRunner {
    override fun run(args: ApplicationArguments?) {
        while (true) {
            kafkaTemplate.send(topicName, Instant.now().toString());
            Thread.sleep(1000L)
        }
    }
}