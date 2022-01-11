package com.github.bvfnbk.plopp.client

import com.github.bvfnbk.plopp.client.components.application.Application
import kotlinx.browser.document
import kotlinx.browser.window
import react.dom.render

fun main() {
    window.onload = {
        render(document.getElementById("root")) {
            child(Application::class) {
                attrs {
                }
            }
        }
    }
}
