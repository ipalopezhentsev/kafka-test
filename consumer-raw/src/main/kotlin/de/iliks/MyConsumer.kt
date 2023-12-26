package de.iliks

import org.apache.kafka.clients.consumer.ConsumerRebalanceListener
import org.apache.kafka.clients.consumer.KafkaConsumer
import org.apache.kafka.common.TopicPartition
import org.apache.kafka.common.serialization.StringDeserializer
import java.time.Duration
import java.util.*

fun main(args: Array<String>) {
    val kafkaProps = Properties()
    kafkaProps["bootstrap.servers"] = "172.28.42.196:9092"
    kafkaProps["enable.auto.commit"] = false
    kafkaProps["group.id"] = "myGroup"
    //if the consumer group does _not_ have offset yet, will set it to earliest (by default it's latest!)
    kafkaProps["auto.offset.reset"] = "earliest"
    val topic = "q"

    KafkaConsumer(kafkaProps, StringDeserializer(), StringDeserializer()).use { kafkaConsumer ->
        println("1!!!!!!!!!!!!!!!!!")
        kafkaConsumer.subscribe(listOf(topic), object : ConsumerRebalanceListener {
            override fun onPartitionsRevoked(partitions: Collection<TopicPartition>) {
                println("Partitions revoked: $partitions")
            }

            override fun onPartitionsAssigned(partitions: Collection<TopicPartition>) {
                println("Partitions assigned: $partitions")
            }
        })
        println("2!!!!!!!!!!!!!!!!!")
//        kafkaConsumer.seekToBeginning(emptyList())

//        println("3!!!!!!!!!!!!!!!!!")
        while (true) {
            val records = kafkaConsumer.poll(Duration.ofMillis(100))
            records.partitions()
            Thread.sleep(5000)
            for (record in records) {
//                println("Key: ${record.key()}, Val: ${record.value()}")
                println(record)
            }
            kafkaConsumer.commitSync()
        }
    }
}