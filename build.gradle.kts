val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project

plugins {
    kotlin("multiplatform") version "1.6.0" apply false
    kotlin("plugin.serialization") version "1.6.0" apply false
}

allprojects {
    group = "com.github.bvfnbk"
    version = "0.0.1"

    repositories {
        mavenCentral()
    }
}
