package com.github.bvfnbk.plopp.client.extension

import kotlinx.css.Color
import kotlinx.css.rgb

/**
 * Creates a RGB encoded color using given value for all colors.
 *
 * @param value The color dimension to use for red, green and blue
 */
fun Color.Companion.linearRgb(value: Int): Color = rgb(value, value, value)
