package br.com.gabriel.marvel.usuarios.dto

import java.time.LocalDate

data class NovoUsuarioResponse(
    val nome:String,
    val email:String,
    val cpf:String,
    val nascimento: LocalDate
){
    constructor(request: NovoUsuarioRequest) : this(request.nome, request.email,request.cpf, request.nascimento)
}