package com.github.bvfnbk.plopp.api.service

import org.springframework.web.reactive.socket.WebSocketSession

/**
 * @author bvfnbk
 */
interface SessionService {
    fun get(id: String): WebSocketSession?

    fun register(id: String, session: WebSocketSession)

    fun contains(id: String): Boolean
}
