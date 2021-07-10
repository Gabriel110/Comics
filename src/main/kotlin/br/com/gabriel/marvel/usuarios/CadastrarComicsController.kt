package br.com.gabriel.marvel.usuarios

import br.com.gabriel.marvel.usuarios.client.ClientMarvel
import br.com.gabriel.marvel.usuarios.dto.NovoUsarioComicRequest
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/marvel/comics")
class CadastrarComicsController(
    @field:Autowired private val cliente: ClientMarvel,
    @field:Autowired private val repository: ComicsRepository,
    @field:Autowired private val usuarioRepository: UsuarioRepository
) {
    private val LOGGER = LoggerFactory.getLogger(this::class.java)
    //@RequestBody request:NovoUsarioComicRequest
    @PostMapping("/cadastrar/{id}/{idUsuario}")
    fun buscaComic(@PathVariable id:Long, @PathVariable idUsuario:Long):ResponseEntity<Any>{
       val usuario = usuarioRepository.findById(idUsuario)
       if (usuario.isEmpty) return ResponseEntity.notFound().build()

        val resp = cliente.buscarComic(id)

        val comic = resp.toModel(usuario.get())

        repository.save(comic)
        //LOGGER.info(resp.toString())
        return ResponseEntity.ok().build()
    }
}