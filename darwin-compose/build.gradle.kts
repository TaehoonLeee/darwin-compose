import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget
import org.jetbrains.compose.experimental.dsl.IOSDevices

plugins {
	kotlin("multiplatform")
	id("org.jetbrains.compose")
}

kotlin {
	iosX64("uikitX64") {
		binaries {
			executable {
				entryPoint = "com.example.darwincompose.app.main"
				freeCompilerArgs += listOf(
					"-linker-option", "-framework", "-linker-option", "Metal",
					"-linker-option", "-framework", "-linker-option", "CoreText",
					"-linker-option", "-framework", "-linker-option", "CoreGraphics"
				)
			}
		}
	}

	sourceSets {
		commonMain {
			dependencies {
				implementation(project(mapOf("path" to ":shared")))
				implementation(project(mapOf("path" to ":ui-compose")))
				implementation(compose.material)
				implementation(compose.foundation)
			}
		}
	}
}

compose.experimental {
	uikit.application {
		bundleIdPrefix = "com.example"
		projectName = "DarwinCompose"

		deployConfigurations {
			simulator("IPhone12Pro") {
				//Usage: ./gradlew iosDeployIPhone12ProDebug
				device = IOSDevices.IPHONE_13_PRO
			}
		}
	}
}

kotlin {
	targets.withType<KotlinNativeTarget> {
		binaries.all {
			freeCompilerArgs += "-Xdisable-phases=VerifyBitcode"
		}
	}
}