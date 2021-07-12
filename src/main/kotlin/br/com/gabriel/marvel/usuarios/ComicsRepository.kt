package br.com.gabriel.marvel.usuarios

import br.com.gabriel.marvel.usuarios.model.Comic
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface ComicsRepository:JpaRepository<Comic,Long> {
    fun findAllById(id: Long): List<Comic>

    @Query("SELECT c FROM Comic c  WHERE c.usuario.id = :id")
    fun buscarComicsDoUsuario(id:Long):List<Comic>


}