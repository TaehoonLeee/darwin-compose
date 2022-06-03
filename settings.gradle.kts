pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

rootProject.name = "Darwin_Compose"
include(":androidApp")
include(":shared")
include(":ui-compose")
include(":darwin-compose")
