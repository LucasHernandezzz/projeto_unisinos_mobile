package com.epi.app

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class EpiApplication

fun main(args: Array<String>) {
	runApplication<EpiApplication>(*args)
}
