import net.stckoverflw.ratio.generator.GenerateTask
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("multiplatform") version "1.6.21"
}

group = "net.stckoverflw"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
}

kotlin {
    explicitApi()

    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "1.8"
        }
    }

    sourceSets {
        commonMain {
           kotlin.srcDir("src/commonGenerated")
        }
    }
}

tasks {
    task<GenerateTask>("generateWordsFile") {
        words.set(file("words.txt").readLines().filterNot { it.startsWith('#') })
        output.set(file("src/commonGenerated/").toPath())
    }
}
