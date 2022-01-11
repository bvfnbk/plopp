package com.github.bvfnbk.plopp.client.components.application

import com.github.bvfnbk.plopp.client.DefaultTheme
import kotlinx.css.*
import styled.StyleSheet

/**
 * @author bvfnbk
 */
object ApplicationStyles : StyleSheet("ApplicationStyles", isStatic = true) {
    val application by css {
        margin(0.px)
        padding(0.px)


        display = Display.flex
        flexDirection = FlexDirection.column

        minHeight = 0.vh
        height = 100.vh

        backgroundColor = DefaultTheme.default.background
        color = DefaultTheme.default.foreground
    }
}
