package me.timur.docs.utils

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import kotlin.streams.toList

object DefaultResponses {
    fun error(status: HttpStatus = HttpStatus.INTERNAL_SERVER_ERROR,  description: String = "Unexpected error"): ResponseEntity<*>{
        val json = HashMap<String, String>()
        json["error"] = status.reasonPhrase
        json["description"] = description

        return ResponseEntity.status(status).body(json)
    }

    fun list(item: List<Any>) : ResponseEntity<*> {
        return ResponseEntity.ok(jacksonObjectMapper().writeValueAsString(item))
    }

    inline fun <T, reified B> listToDto (items: List<B>, dtoClass: Class<T>) : ResponseEntity<*>{
        val resultList: List<T> = items.stream().map { dtoClass.getConstructor(B::class.java).newInstance(it) }.toList()
        val result = jacksonObjectMapper().writeValueAsString(resultList)
        return ResponseEntity.ok(result)
    }

    fun single(item: Any) : ResponseEntity<*> {
        return ResponseEntity.ok(jacksonObjectMapper().writeValueAsString(item))
    }

    inline fun <T, reified B> singleToDto(item: B, dtoClass: Class<T>) : ResponseEntity<*> {
        val result = dtoClass.getConstructor(B::class.java).newInstance(item)
        return ResponseEntity.ok(jacksonObjectMapper().writeValueAsString(result))
    }

    inline fun <reified T> created(body: T): ResponseEntity<T> {
        return ResponseEntity.status(HttpStatus.CREATED).body(body)
    }
}