package com.github.bvfnbk.plopp.client.components.application.content

import com.github.bvfnbk.plopp.client.DefaultTheme
import kotlinx.css.*
import styled.StyleSheet

/**
 * @author bvfnbk
 */
object MainContentStyles : StyleSheet("MainContentStyles", isStatic = true) {
    val mainContent by css {
        flex(1.0)
        overflowY = Overflow.auto

        margin(24.px)

        backgroundColor = DefaultTheme.default.background
        color = DefaultTheme.default.foreground
    }
}
