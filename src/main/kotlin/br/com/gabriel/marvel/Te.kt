package br.com.gabriel.marvel

import java.math.BigDecimal
import java.math.RoundingMode

fun main() {
    val x = BigDecimal("20000").setScale(2,RoundingMode.FLOOR)

    val desconto = x - x.multiply(BigDecimal("0.1"))
    println(desconto)
}