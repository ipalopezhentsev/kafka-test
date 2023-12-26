package de.iliks

import org.apache.kafka.clients.producer.*
import org.apache.kafka.common.KafkaException
import org.apache.kafka.common.errors.AuthorizationException
import org.apache.kafka.common.errors.OutOfOrderSequenceException
import org.apache.kafka.common.errors.ProducerFencedException
import org.apache.kafka.common.serialization.StringSerializer
import java.util.Properties
import kotlin.Exception

class MyProducer(
    private val kafkaProducer: Producer<String, String>,
    private val topicName: String,
) {
    fun produce(n: Int) {
        val keys=listOf("b1", "b2", "b3")

        try {
            kafkaProducer.beginTransaction()
            for (i in 0 until n) {
                val key = keys[i % keys.size]
                val producerRecord = ProducerRecord(topicName, key, i.toString())
                kafkaProducer.send(producerRecord)
            }
            kafkaProducer.commitTransaction()
        } catch (ex: Exception) {
            when (ex) {
                is ProducerFencedException, is OutOfOrderSequenceException, is AuthorizationException -> kafkaProducer.close()
                is KafkaException -> kafkaProducer.abortTransaction()
            }
        }
    }
}

fun main(args: Array<String>) {
    val kafkaProps = Properties()
    kafkaProps["bootstrap.servers"] = "172.28.42.196:9092"
    kafkaProps["transactional.id"] = "ilya"
    val topic = "q"
    KafkaProducer(kafkaProps, StringSerializer(), StringSerializer()).use { kafkaProducer ->
        kafkaProducer.initTransactions()
        val p = MyProducer(kafkaProducer, topic)
        p.produce(10_000)
    }
}