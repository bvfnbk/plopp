package com.github.bvfnbk.plopp.client.components.application.bar

import com.github.bvfnbk.plopp.client.DefaultTheme
import kotlinx.css.*
import styled.StyleSheet

/**
 * @author bvfnbk
 */
object ApplicationBarStyles : StyleSheet("ApplicationBarStyles", isStatic = true) {
    val appBar by css {
        flex(0.0)

        display = Display.flex
        alignItems = Align.center

        padding(1.5.rem)

        backgroundColor = DefaultTheme.inverse.background
        color = DefaultTheme.inverse.foreground
    }
}
