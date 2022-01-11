package com.github.bvfnbk.plopp.client.components.application.bar

import react.RBuilder
import react.RComponent
import react.State
import styled.styledDiv
import styled.css

/**
 * @author bvfnbk
 */
class ApplicationBar(properties: ApplicationBarProperties) : RComponent<ApplicationBarProperties, State>(properties) {
    override fun RBuilder.render() {
        styledDiv {
            css {
                +ApplicationBarStyles.appBar
            }
            +"Hello application bar."
        }
    }
}
