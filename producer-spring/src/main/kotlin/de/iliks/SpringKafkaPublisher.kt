package de.iliks

import org.springframework.beans.factory.annotation.Value
//import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class SpringKafkaPublisher(
//    private val kafkaTemplate: KafkaTemplate<String, String>,
    @Value("\${kafka.topic}")
    private val topicName: String
) {
    fun massSend() {

    }

    fun sendMessage(msg: String) {
//        kafkaTemplate.send(topicName, msg);
    }
}