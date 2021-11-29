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
