package com.roohoo.SpringDatabase

import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled

@SpringBootApplication
@EnableScheduling
class SpringDatabaseApplication

val logger = LoggerFactory.getLogger(SpringDatabaseApplication::class.java)!!

fun main(args: Array<String>) {
    runApplication<SpringDatabaseApplication>(*args)
}


