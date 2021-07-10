package br.com.gabriel.marvel.usuarios.model

import java.time.LocalDate
import javax.persistence.*

@Entity
class Usuario (
    @Column(nullable = false)
    val nome:String,
    @Column(nullable = false, unique = true)
    val email:String,
    @Column(nullable = false, unique = true)
    val cpf:String,
    val nascimento: LocalDate
){
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id:Long? = null
}