package com.github.bvfnbk.plopp.framework.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.HandlerMapping
import org.springframework.web.reactive.handler.SimpleUrlHandlerMapping
import org.springframework.web.reactive.socket.WebSocketHandler

/**
 * @author bvfnbk
 */
@Configuration
class WebSocketConfiguration(private val handler: WebSocketHandler) {
    @Bean
    fun handlerMapping(): HandlerMapping = SimpleUrlHandlerMapping(mapOf("events" to handler), 1)
}
