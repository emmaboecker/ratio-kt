import net.stckoverflw.ratio.generator.GenerateTask

plugins {
    kotlin("multiplatform") version "1.7.22"
    `maven-publish`
}

group = "net.stckoverflw"
version = "1.2"

repositories {
    mavenCentral()
}

kotlin {
    explicitApi()

    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "1.8"
        }
    }

    js(BOTH) {
        browser()
        nodejs()
    }

    mingwX64()
    linuxX64()
    tvos()
    watchos()
    ios()
    macosArm64()
    macosX64()

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

publishing {
    repositories {
        maven {
            setUrl("https://maven.stckoverflw.net/releases")

            credentials {
                username = System.getenv("MAVEN_USERNAME")
                password = System.getenv("MAVEN_SECRET")
            }
        }
    }

    publications {
        filterIsInstance<MavenPublication>().forEach { publication ->
            publication.pom {
                name.set(project.name)
                description.set("ratio + don't care, in your kotlin code")
                url.set("https://github.com/StckOverflw/ratio-kt")

                licenses {
                    license {
                        name.set("MIT License")
                        url.set("https://github.com/StckOverflw/ratio-kt/blob/main/LICENSE")
                    }
                }

                developers {
                    developer {
                        name.set("Emma Böcker")
                        email.set("stckoverflw@gmail.com")
                        organizationUrl.set("https://www.stckoverflw.net")
                    }
                }

                scm {
                    connection.set("scm:git:https://github.com/StckOverflw/ratio-kt.git")
                    developerConnection.set("scm:git:https://github.com/StckOverflw/ratio-kt.git")
                    url.set("https://github.com/StckOverflw/ratio-kt")
                }
            }
        }
    }
}
