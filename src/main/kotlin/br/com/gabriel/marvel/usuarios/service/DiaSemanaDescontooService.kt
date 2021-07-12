package br.com.gabriel.marvel.usuarios.service

import br.com.gabriel.marvel.usuarios.ComicsRepository
import br.com.gabriel.marvel.usuarios.model.Comic
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import java.time.LocalDate


@Service
class DiaSemanaDescontooService(
    @field:Autowired private val comicsRepository: ComicsRepository
) {
    lateinit var isbn:String;
    private val LOGGER = LoggerFactory.getLogger(this::class.java)
    fun diaSemana(resp: Comic){

        if(resp.isbn.endsWith("0") || resp.isbn.endsWith("1") ) isbn = "segunda-feira"
        if(resp.isbn.endsWith("2") || resp.isbn.endsWith("3") ) isbn = "terça-feira"
        if(resp.isbn.endsWith("4") || resp.isbn.endsWith("5") ) isbn = "quarta-feira"
        if(resp.isbn.endsWith("6") || resp.isbn.endsWith("7") ) isbn = "quinta-feira"
        if(resp.isbn.endsWith("8") || resp.isbn.endsWith("9") ) isbn = "sexta-feira"

        resp.diaDesconto = isbn
        comicsRepository.save(resp)
    }

    fun weekDay(diaSemana: String): String {
        if (diaSemana.equals("MONDAY")) return "segunda-feira"
        if (diaSemana.equals("TUESDAY")) return "terça-feira"
        if (diaSemana.equals("WEDNESDAY")) return "quarta-feira"
        if (diaSemana.equals("THURSDAY")) return "quinta-feira"
        if (diaSemana.equals("FRIDAY")) return "sexta-feira"

        return " "
    }
}

@Component
class AtualizarDescontoAtivo(
    @field:Autowired private val comicsRepository: ComicsRepository,
    @field:Autowired private val dia:DiaSemanaDescontooService
){
    private val LOGGER = LoggerFactory.getLogger(this::class.java)

    @Scheduled(fixedDelay = 11000)
    fun teste(){
        val diaSemana = LocalDate.now().dayOfWeek.toString()
        val comic = comicsRepository.findAll()
        comic.map { if(it.diaDesconto == dia.weekDay(diaSemana)) it.descontoAtivo = true }
        comicsRepository.saveAll(comic)
        LOGGER.info("Atualizado!")
    }
}