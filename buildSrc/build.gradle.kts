plugins {
    groovy
    `kotlin-dsl`
    kotlin("jvm") version "1.6.21"
}

repositories {
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    implementation("com.squareup", "kotlinpoet", "1.12.0")
    implementation(gradleApi())
    implementation(localGroovy())
}