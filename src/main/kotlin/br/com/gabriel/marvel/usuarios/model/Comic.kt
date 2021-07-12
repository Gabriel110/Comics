package br.com.gabriel.marvel.usuarios.model

import java.math.BigDecimal
import javax.persistence.*
import kotlin.math.max

@Entity
class Comic(
    val comicId:Long,
    val titulo:String,
    @Column(length = 3000)
    val descricao:String,
    var isbn:String,
    val preco:BigDecimal,
    @OneToMany(cascade = [CascadeType.ALL], mappedBy = "idComic")
    val autores:List<Autores>? = arrayListOf(),
    @ManyToOne
    val usuario: Usuario,
    var diaDesconto:String? = null,
    var descontoAtivo:Boolean = false,
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id:Long? = null
}