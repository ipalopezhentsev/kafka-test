package de.iliks

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ConsumerSpringApplication

fun main(args: Array<String>) {
    runApplication<ConsumerSpringApplication>(*args)
}
