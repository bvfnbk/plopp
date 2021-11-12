package com.github.bvfnbk.plopp.framework.service

import com.github.bvfnbk.plopp.api.service.SessionService
import com.github.bvfnbk.plopp.framework.Slf4jLogger
import org.slf4j.Logger
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service
import org.springframework.web.reactive.socket.WebSocketHandler
import org.springframework.web.reactive.socket.WebSocketSession
import reactor.core.publisher.Mono

/**
 * Responsible for accepting web socket connections and to register sessions at a [SessionService]
 * @author bvfnbk
 */
@Service
class PloppWebSocketHandlerService(
    private val sessionService: SessionService,
    private val publisher: ApplicationEventPublisher
) : WebSocketHandler {
    override fun handle(session: WebSocketSession): Mono<Void> {
        logger.info("handle(${session.id})")

        if (!sessionService.contains(session.id)) {
            sessionService.register(session.id, session)
        }

        // this is basically the 'connect' -> register session & provide ping pong event handler...
        return session.send(
            session.receive()
                .map { it.payloadAsText }
                .map { session.textMessage(it.uppercase()) }
        )
    }

    companion object {
        @Slf4jLogger
        lateinit var logger: Logger
    }
}
