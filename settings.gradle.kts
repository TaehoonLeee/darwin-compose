pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

rootProject.name = "Darwin_Compose"
val modules = arrayOf(":androidApp", ":shared")
include(*modules)
