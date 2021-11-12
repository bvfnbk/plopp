package com.github.bvfnbk.plopp.service

import com.github.bvfnbk.plopp.api.service.SessionService
import com.github.bvfnbk.plopp.framework.Slf4jLogger
import org.slf4j.Logger
import org.springframework.stereotype.Service
import org.springframework.web.reactive.socket.WebSocketSession

/**
 * @author bvfnbk
 */
@Service
class InMemorySessionService : SessionService {
    companion object {
        @Slf4jLogger
        lateinit var logger: Logger
    }

    private val sessionMap = mutableMapOf<String, WebSocketSession>()

    override fun get(id: String): WebSocketSession? = when {
        contains(id) -> sessionMap[id]
        else -> null
    }

    override fun register(id: String, session: WebSocketSession) {
        logger.info("register({}}", id)

        if (!contains(id)) {
            sessionMap[id] = session
        }
    }

    override fun contains(id: String): Boolean {
        logger.info("contains({})", id)

        return sessionMap.containsKey(id)
    }
}
