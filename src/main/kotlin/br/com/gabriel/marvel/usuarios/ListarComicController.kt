package br.com.gabriel.marvel.usuarios

import br.com.gabriel.marvel.usuarios.dto.ComicResponse
import br.com.gabriel.marvel.usuarios.model.Comic
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.math.BigDecimal
import java.math.RoundingMode
import java.time.LocalDate
import java.util.*

@RestController
@RequestMapping("/api/marvel")
class ListarComicController(
   @field:Autowired private val comicsRepository: ComicsRepository,
   @field:Autowired private val usuarioRepository: UsuarioRepository
) {

    private val LOGGER = LoggerFactory.getLogger(ListarComicController::class.java)
    @GetMapping("/listar/comics/{id}")
    fun listar(@PathVariable id:Long):ResponseEntity<Any>{
        if(!usuarioRepository.existsById(id)) return ResponseEntity.notFound().build()
        val comics:List<Comic> = comicsRepository.buscarComicsDoUsuario(id)

        return ResponseEntity.ok(comics.map {
            var precoComDisconto: BigDecimal = it.preco
            if(it.descontoAtivo == true) precoComDisconto = it.preco - it.preco.multiply(BigDecimal("0.1"))
            ComicResponse(it,precoComDisconto.setScale(2,RoundingMode.FLOOR))
        })
    }
}