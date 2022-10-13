plugins {
    groovy
    `kotlin-dsl`
    kotlin("jvm") version "1.7.20"
}

repositories {
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    implementation("com.squareup", "kotlinpoet", "1.11.0")
    implementation(gradleApi())
    implementation(localGroovy())
}