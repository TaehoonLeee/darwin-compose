package com.example.darwincompose.uicompose

import io.ktor.client.*
import io.ktor.client.engine.darwin.*

actual val httpClient: HttpClient = HttpClient(Darwin)