package br.com.gabriel.marvel.config.ErroHandler

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.MessageSource
import org.springframework.context.i18n.LocaleContextHolder
import org.springframework.http.HttpStatus
import org.springframework.validation.FieldError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ErroHandelerAdivice(
    @field:Autowired private val messageSource: MessageSource
) {

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handler(exception: MethodArgumentNotValidException):List<ErroResponse>{
        val erros = ArrayList<ErroResponse>()
        val fieldErrors:List<FieldError> = exception.getFieldErrors()

        fieldErrors.forEach{e->
            val message:String = messageSource.getMessage(e, LocaleContextHolder.getLocale())
            val erro = ErroResponse(e.field, message)

            erros.add(erro)
        }

        return erros
    }
}

data class ErroResponse(
    val campo:String,
    val erro:String
)