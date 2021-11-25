package com.github.bvfnbk.plopp.plugins

import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.ContentNegotiation
import io.ktor.response.respond
import io.ktor.routing.get
import io.ktor.routing.routing
import io.ktor.serialization.json

fun Application.configureSerialization() {
    install(ContentNegotiation) {
        json()
    }

    routing {
        get("/api/hello") {
            if (call.request.queryParameters.contains("name")) {
                call.respond(mapOf("hello" to call.request.queryParameters["name"]))
            } else {
                call.respond(mapOf("hello" to "World"))
            }
        }
    }
}
