package com.itmo.microservices.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DemoServiceApplication {
    annotation class SpringBootApplication
}

fun main(args: Array<String>) {
    runApplication<DemoServiceApplication>(*args)
}