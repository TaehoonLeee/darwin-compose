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
			}
		}
	}
}

android {
	compileSdk = 31
	sourceSets["main"].manifest.srcFile("src/main/AndroidManifest.xml")
}