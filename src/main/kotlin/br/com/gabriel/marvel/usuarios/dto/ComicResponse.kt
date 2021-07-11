package br.com.gabriel.marvel.usuarios.dto

import br.com.gabriel.marvel.usuarios.model.Autores
import br.com.gabriel.marvel.usuarios.model.Comic
import java.math.BigDecimal


data class ComicResponse (
    val id:Long?,
    val comicId:Long,
    val titulo:String,
    val descricao:String,
    val isbn:String,
    val preco: BigDecimal,
    val autores:List<Autores>?,
    val usuarioId: Long?
){
    constructor(comic:Comic):this(
        comic.id,
        comic.comicId,
        comic.titulo,
        comic.descricao,
        comic.isbn,
        comic.preco,
        comic.autores,
        comic.usuario.id
    )
}

