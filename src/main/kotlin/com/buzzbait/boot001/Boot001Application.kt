package com.buzzbait.boot001

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@EnableJpaAuditing
@SpringBootApplication
class Boot001Application

fun main(args: Array<String>) {
	runApplication<Boot001Application>(*args)
}
