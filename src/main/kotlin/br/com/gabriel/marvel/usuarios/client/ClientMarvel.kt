package br.com.gabriel.marvel.usuarios.client

import br.com.gabriel.marvel.usuarios.model.Autores
import br.com.gabriel.marvel.usuarios.model.Comic
import br.com.gabriel.marvel.usuarios.model.Usuario
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import java.math.BigDecimal
import java.math.RoundingMode

@FeignClient(name = "marvel", url = "http://gateway.marvel.com/v1/public/comics")
interface ClientMarvel {

    @GetMapping("/{id}?ts=1625877592&apikey=75c494608b0f4ed2ae1ac84b879c67b1&hash=25b28dae5af30ee4917921dc717fa3dc")
    fun buscarComic(@PathVariable id:Long ):ClienteMarvelResponse
}

data class ClienteMarvelResponse(
    val code: Int,
    val status: String,
    val data:DataResponse
) {
    fun toModel(usuario: Usuario): Comic {
        return Comic(
            data.results[0].id,
            data.results[0].title,
            data.results[0].description?:" ",
            data.results[0].isbn,
            BigDecimal(data.results[0].prices[0].price.toString()).setScale(2,RoundingMode.FLOOR),
            data.results[0].creators.items.map { Autores(it.name,  data.results[0].id) },
            usuario
        )
    }

}

data class DataResponse(
    val results:List<ResultResponse>
)

data class ResultResponse(
    val id: Long,
    val title:String,
    val description:String?,
    val isbn:String,
    val prices:List<PriceResponse>,
    val creators:CreatorsResponse
)

data class PriceResponse(
    val price:Float
)

data class CreatorsResponse(
    val items:List<ItensResponse>
)

data class ItensResponse(
    val name: String
)