package br.com.gabriel.marvel.usuarios.model

import br.com.gabriel.marvel.usuarios.client.ItensResponse
import javax.persistence.*

@Entity
class Autores(
    val nome: String,
    val idComic:Long
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id:Long? = null
}