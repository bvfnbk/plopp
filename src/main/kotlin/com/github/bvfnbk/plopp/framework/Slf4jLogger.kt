package com.github.bvfnbk.plopp.framework

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.config.BeanPostProcessor
import org.springframework.stereotype.Component
import kotlin.reflect.KMutableProperty
import kotlin.reflect.full.companionObjectInstance
import kotlin.reflect.full.declaredMemberProperties

/**
 * Source: https://www.sothawo.com/2017/07/annotation-based-logger-injection-in-spring-with-kotlin/
 *
 * @author bvfnbk
 */
@Target(AnnotationTarget.PROPERTY)
annotation class Slf4jLogger


@Component
class LoggingInjector : BeanPostProcessor {
    override fun postProcessBeforeInitialization(bean: Any, beanName: String) =
        bean.also {
            try {
                val loggerName = it::class.java.canonicalName!!
                processObject(it, loggerName)
                it::class.companionObjectInstance?.let { companion ->
                    processObject(companion, loggerName)
                }
            } catch (ignored: Throwable) {

            }
        }

    private fun processObject(target: Any, loggerName: String) {
        target::class.declaredMemberProperties.forEach { property ->
            if (property is KMutableProperty<*>) {
                property.annotations.filterIsInstance(Slf4jLogger::class.java).forEach {
                    property.setter.call(target, LoggerFactory.getLogger(loggerName))
                }
            }
        }
    }
}
