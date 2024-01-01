package de.iliks

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ProducerSpringApplication

fun main(args: Array<String>) {
    runApplication<ProducerSpringApplication>(*args)
}
