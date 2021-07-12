package br.com.gabriel.marvel

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.scheduling.annotation.EnableScheduling

@EnableFeignClients
@EnableScheduling
@SpringBootApplication
open class MarvelApplication

fun main(args: Array<String>) {
	runApplication<MarvelApplication>(*args)
}
