package com.github.bvfnbk.plopp.client

import com.github.bvfnbk.plopp.client.api.ColorCombination
import com.github.bvfnbk.plopp.client.api.HoverableColorCombination
import com.github.bvfnbk.plopp.client.api.Theme
import com.github.bvfnbk.plopp.client.extension.linearRgb
import kotlinx.css.Color

// Blackish
private val black00: Color = Color.linearRgb(0)
private val black10: Color = Color.linearRgb(23)
private val black20: Color = Color.linearRgb(64)
private val black30: Color = Color.linearRgb(84)
private val black40: Color = Color.linearRgb(227)
private val black50: Color = Color.linearRgb(247)
private val black100: Color = Color.linearRgb(255)


/**
 * @author bvfnbk
 */
object DefaultTheme : Theme {
    override val default: HoverableColorCombination = object : HoverableColorCombination {
        override val hover: ColorCombination = object : ColorCombination {
            override val background: Color = black40
            override val foreground: Color = black10
            override val border: Color = black10
        }

        override val background: Color = black100
        override val foreground: Color = black00
        override val border: Color = black10
    }

    override val inverse: HoverableColorCombination = object : HoverableColorCombination {
        override val hover: ColorCombination = object : ColorCombination {
            override val background: Color = black30
            override val foreground: Color = black50
            override val border: Color = black10
        }

        override val background: Color = black20
        override val foreground: Color = black50
        override val border: Color = black10
    }
}
