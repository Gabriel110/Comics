package br.com.gabriel.marvel.usuarios.service

import org.springframework.stereotype.Service
import java.util.*

@Service
class GeradorIsbn {

    fun isbn():String{
        val  n3 = (0..999).random()
        val  n4 = (0..999).random()
        val  n5 = (0..999).random()
        val  n6 = (0..999).random()
        val  n1 = (0..9).random()
        val isbn = "$n3-$n4-$n5-$n6-$n1"

        return isbn
    }
}
