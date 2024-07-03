package de.iliks

import org.apache.kafka.clients.admin.NewTopic
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.config.TopicBuilder

@Configuration
class KafkaConfig {
    @Bean
    fun topic(
        @Value("\${kafka.topic}") topicName: String
    ): NewTopic {
        return TopicBuilder.name(topicName)
            .partitions(2)
            .replicas(1)
            .build()
    }

    @Bean
    fun onStart() = ApplicationRunner {
        println("onStart")
    }
}