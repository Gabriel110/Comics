package br.com.gabriel.marvel

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@EnableFeignClients
@SpringBootApplication
class MarvelApplication

fun main(args: Array<String>) {
	runApplication<MarvelApplication>(*args)
}
