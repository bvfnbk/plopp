package com.github.bvfnbk.plopp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PloppApplication

fun main(args: Array<String>) {
	runApplication<PloppApplication>(*args)
}
