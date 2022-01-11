package com.github.bvfnbk.plopp.client.components.application

import com.github.bvfnbk.plopp.client.components.application.bar.ApplicationBar
import com.github.bvfnbk.plopp.client.components.application.content.MainContent
import react.RBuilder
import react.RComponent
import react.State
import styled.css
import styled.styledDiv

/**
 * @author bvfnbk
 */
class Application(properties: ApplicationProperties) : RComponent<ApplicationProperties, State>(properties) {
    // update state in init {}

    override fun RBuilder.render() {
        styledDiv {
            css {
                +ApplicationStyles.application
            }

            child(ApplicationBar::class) {

            }
            child(MainContent::class) {

            }
        }
    }
}
