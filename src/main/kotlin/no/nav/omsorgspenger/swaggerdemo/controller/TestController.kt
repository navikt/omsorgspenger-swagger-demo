package no.nav.omsorgspenger.swaggerdemo.controller

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.Operation
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/book")
class TestController {

    @Operation(
        summary = "TestCtrl"
    )
    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): String {
        return "The number you're looking for is $id"
    }

    @Operation(
        summary = "TestCtrl"
    )
    @GetMapping("/")
    fun findPersons(): Collection<String> {
        return listOf("Luke Skywalker", "Han Solo", "Chewbacca", "Leia Organa")
    }

}