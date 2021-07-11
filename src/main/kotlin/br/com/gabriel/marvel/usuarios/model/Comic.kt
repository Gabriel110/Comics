package br.com.gabriel.marvel.usuarios.model

import java.math.BigDecimal
import javax.persistence.*

@Entity
class Comic(
    val comicId:Long,
    val titulo:String,
    val descricao:String,
    val isbn:String,
    val preco:BigDecimal,

    @OneToMany(cascade = [CascadeType.ALL], mappedBy = "idComic")
    val autores:List<Autores>? = arrayListOf(),

    @ManyToOne
    val usuario: Usuario
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id:Long? = null
}