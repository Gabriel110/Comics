package br.com.gabriel.marvel.usuarios

import br.com.gabriel.marvel.usuarios.model.Comic
import org.springframework.data.jpa.repository.JpaRepository

interface ComicsRepository:JpaRepository<Comic,Long> {
}