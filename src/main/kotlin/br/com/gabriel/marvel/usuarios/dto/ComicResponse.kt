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
    val diaDesconto:String?,
    val descontoAtivo:Boolean,
    var preco: BigDecimal ,
    val autores:List<Autores>?,
    val usuarioId: Long?
){
    constructor(comic:Comic):this(
       id = comic.id,
       comicId = comic.comicId,
       titulo = comic.titulo,
       descricao = comic.descricao,
       isbn = comic.isbn,
       preco = comic.preco,
       diaDesconto = comic.diaDesconto,
       descontoAtivo = comic.descontoAtivo,
       autores = comic.autores,
       usuarioId = comic.usuario.id
    )
    constructor(comic:Comic, desconto:BigDecimal):this(
        id = comic.id,
        comicId = comic.comicId,
        titulo = comic.titulo,
        descricao = comic.descricao,
        isbn = comic.isbn,
        preco = desconto,
        diaDesconto = comic.diaDesconto,
        descontoAtivo = comic.descontoAtivo,
        autores = comic.autores,
        usuarioId = comic.usuario.id
    )
}

