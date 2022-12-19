import org.jetbrains.compose.experimental.dsl.IOSDevices

plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("com.android.library")
    id("org.jetbrains.compose")
}

version = "1.0"

kotlin {
    android()

    listOf(iosX64("uikitX64"), iosArm64("uikitArm64")).forEach {
        it.binaries {
            executable {
                entryPoint = "main"
                freeCompilerArgs += listOf(
                    "-linker-option", "-framework", "-linker-option", "Metal",
                    "-linker-option", "-framework", "-linker-option", "CoreText",
                    "-linker-option", "-framework", "-linker-option", "CoreGraphics",
					"-Xverify-compiler=false"
                )
            }
        }
    }

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        ios.deploymentTarget = "14.1"
        podfile = project.file("../iosApp/Podfile")
        framework {
            baseName = "shared"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.material)
                implementation(compose.foundation)
            }
        }
        val uikitMain by creating {
            dependsOn(commonMain)
        }
        getByName("uikitX64Main").dependsOn(uikitMain)
        getByName("uikitArm64Main").dependsOn(uikitMain)
    }
}

android {
    compileSdk = 32
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = 28
        targetSdk = 32
    }
}

compose.experimental {
    uikit.application {
        bundleIdPrefix = "com.example"
        projectName = "DarwinCompose"

        deployConfigurations {
            simulator("IPhone12Pro") {
                //Usage: ./gradlew iosDeployIPhone12ProDebug
                device = IOSDevices.IPHONE_12_PRO
            }
        }
    }
}