package br.com.gabriel.marvel.usuarios

import br.com.gabriel.marvel.usuarios.dto.NovoUsuarioRequest
import br.com.gabriel.marvel.usuarios.dto.NovoUsuarioResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid


@RestController
@RequestMapping("/api/marvel")
class CadastrarUsuariosController(
    @field:Autowired private val repository: UsuarioRepository
) {

    @PostMapping("/cadastrar")
    fun cadastrar(@RequestBody @Valid requet:NovoUsuarioRequest):ResponseEntity<Any> {
        if(repository.existsByEmail(requet.email))
            return ResponseEntity.unprocessableEntity().body("Email deve ser unico")

        if(repository.existsByCpf(requet.cpf))
            return  ResponseEntity.unprocessableEntity().body("Cpf deve ser unico")

        repository.save(requet.toModel())
        return ResponseEntity.ok(NovoUsuarioResponse(requet))
    }

}