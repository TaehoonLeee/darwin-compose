package com.example.darwincompose.uicompose

import androidx.compose.foundation.Image
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.toComposeImageBitmap
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.utils.io.core.*

@Composable
fun MainContent() {
	val bitmap by produceState<ImageBitmap?>(null) {
		val image = httpClient.use {
			it.get("https://picsum.photos/200/300")
				.body<ByteArray>()
		}

		value = org.jetbrains.skia.Image.makeFromEncoded(image).toComposeImageBitmap()
	}

	bitmap?.let {
		Image(
			bitmap = it, contentDescription = null
		)
	}?: Text("Test")
}