package br.com.gabriel.marvel.usuarios

import br.com.gabriel.marvel.usuarios.client.ClientMarvel
import br.com.gabriel.marvel.usuarios.dto.ComicResponse
import br.com.gabriel.marvel.usuarios.service.GeradorIsbn
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/api/marvel/comics")
class CadastrarComicsController(
    @field:Autowired private val cliente: ClientMarvel,
    @field:Autowired private val repository: ComicsRepository,
    @field:Autowired private val usuarioRepository: UsuarioRepository,
    @field:Autowired private val isbnGerator:GeradorIsbn
) {
    private val LOGGER = LoggerFactory.getLogger(this::class.java)
    //@RequestBody request:NovoUsarioComicRequest
    @PostMapping("/cadastrar/{id}/{idUsuario}")
    fun buscaComic(@PathVariable id:Long, @PathVariable idUsuario:Long, uriBuilder:UriComponentsBuilder):ResponseEntity<Any>{
       val usuario = usuarioRepository.findById(idUsuario)
        if (usuario.isEmpty) return ResponseEntity.notFound().build()

        val resp = cliente.buscarComic(id)

        val comic = resp.toModel(usuario.get(), isbnGerator)

        val dado = repository.save(comic)
        //LOGGER.info(resp.toString())
        val uri = uriBuilder.path("/api/marvel/comics/detalhar/{id}").buildAndExpand(dado.id).toUri()
        return ResponseEntity.created(uri).body(ComicResponse(dado))
    }
}