package de.iliks

import org.springframework.boot.ApplicationRunner
import org.springframework.boot.context.event.ApplicationStartedEvent
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.event.EventListener
//import org.springframework.kafka.annotation.KafkaListener
//import org.springframework.kafka.config.TopicBuilder

@Configuration
class KafkaConfig {
//    @Bean
//    fun topic(): NewTopic? {
//        return TopicBuilder.name("q")
//            .partitions(2)
//            .replicas(1)
//            .build()
//    }
//
//    @KafkaListener(id = "springId", topics = ["q"])
//    fun listen(str: String?, /*ack: Acknowledgment, */r: ConsumerRecord<*,*>) {
//        println(str)
//    }

    @Bean
    fun onStart() = ApplicationRunner {
        println("onStart")
    }
}