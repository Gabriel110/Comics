package br.com.gabriel.marvel.usuarios.dto

import br.com.gabriel.marvel.usuarios.model.Usuario
import org.hibernate.validator.constraints.br.CPF
import java.time.LocalDate
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class NovoUsuarioRequest (
    @field:NotBlank @field:NotNull
    val nome:String,
    @field:NotBlank @field:NotNull @field:Email
    val email:String,
    @field:NotBlank @field:NotNull @field:CPF
    val cpf:String,
    @field:NotNull
    val nascimento:LocalDate
) {
    fun toModel(): Usuario {
        return  Usuario(
            nome,
            email,
            cpf,
            nascimento
        )
    }
}