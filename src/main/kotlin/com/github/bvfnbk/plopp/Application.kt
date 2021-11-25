package com.github.bvfnbk.plopp

/**
 *
 */
import com.github.bvfnbk.plopp.plugins.configureRouting
import com.github.bvfnbk.plopp.plugins.configureSerialization
import com.github.bvfnbk.plopp.plugins.configureSockets
import io.ktor.server.cio.CIO
import io.ktor.server.engine.embeddedServer

internal fun getPort(defaultPort: Int): Int {
    return System.getenv("PORT")?.toInt() ?: defaultPort
}

fun main() {
    embeddedServer(CIO, port = getPort(8080), host = "0.0.0.0") {
        configureRouting()
        configureSerialization()
        configureSockets()
    }.start(wait = true)
}
