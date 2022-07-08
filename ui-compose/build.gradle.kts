plugins {
	kotlin("multiplatform")
	id("com.android.library")
	id("org.jetbrains.compose")
}

kotlin {
	ios()
	android()

	sourceSets {
		commonMain {
			dependencies {
				implementation(compose.material)
				implementation(compose.foundation)
				implementation("io.ktor:ktor-client-core:2.0.2")
			}
		}

		val androidMain by getting {
			dependencies {
				implementation("io.ktor:ktor-client-okhttp:2.0.2")
			}
		}

		val iosMain by getting {
			dependencies {
				implementation("io.ktor:ktor-client-darwin:2.0.2")
			}
		}
	}
}

android {
	compileSdk = 31
	sourceSets["main"].manifest.srcFile("src/main/AndroidManifest.xml")
}