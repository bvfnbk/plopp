package com.github.bvfnbk.plopp.controller

import com.github.bvfnbk.plopp.api.service.SessionService
import com.github.bvfnbk.plopp.framework.Slf4jLogger
import org.slf4j.Logger
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
class HelloWorldController(
    private val sessionService: SessionService
) {
    companion object {
        @Slf4jLogger
        lateinit var logger: Logger
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun hello(@RequestParam(required = false, defaultValue = "World") name: String): Mono<String> {
        logger.info("hello($name)")


        val id = name
        val message = "Hello ${name}"
        val session = sessionService.get(id)

        return session?.send(
            Mono.just(session.textMessage("${message} via Socket"))
        )?.map {
            message
        } ?: Mono.just(message)
    }
}
