package com.github.bvfnbk.plopp.controller

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono

/**
 * Test controller to check Heroku setup.
 *
 * @author bvfnbk
 */
@RestController
@RequestMapping("api/hello")
class HelloWorldController {
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun hello(@RequestParam(required = false, defaultValue = "World") name: String): Mono<String> = Mono.just(
        "Hello $name"
    )
}
