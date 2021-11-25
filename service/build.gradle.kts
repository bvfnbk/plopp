val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project

plugins {
    application
    distribution
    kotlin("jvm")
    kotlin("plugin.serialization")
}

application {
    mainClass.set("com.github.bvfnbk.plopp.ApplicationKt")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-server-core:$ktor_version")
    implementation("io.ktor:ktor-server-host-common:$ktor_version")
    implementation("io.ktor:ktor-serialization:$ktor_version")
    implementation("io.ktor:ktor-websockets:$ktor_version")
    implementation("io.ktor:ktor-server-cio:$ktor_version")
    implementation("ch.qos.logback:logback-classic:$logback_version")

    testImplementation("io.ktor:ktor-server-tests:$ktor_version")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")
}

// cf. https://ktor.io/docs/heroku.html
tasks.create("stage") {
    dependsOn("installDist")
}
