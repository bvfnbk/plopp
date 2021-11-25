package com.github.bvfnbk.plopp.plugins

import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.content.*
import io.ktor.http.content.*
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*

fun Application.configureRouting() {


    routing {
        static("/") {
            // Serve all files from: src/main/resources/static/
            resources("static")

            // Serve default file (index.html)
            defaultResource("static/index.html")
        }
    }
}
