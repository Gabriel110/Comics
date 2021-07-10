package br.com.gabriel.marvel.usuarios

import br.com.gabriel.marvel.usuarios.model.Usuario
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UsuarioRepository: JpaRepository<Usuario, Long> {
     fun existsByEmail(email: String): Boolean
     fun existsByCpf(cpf: String): Boolean
}