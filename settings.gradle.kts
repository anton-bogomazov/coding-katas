pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}

rootProject.name = "coding-katas"

include(":gilded-rose")
include(":mars-rover")
include(":tell-dont-ask")
include(":race-car")
include(":bowling")
include(":ugly-trivia")
