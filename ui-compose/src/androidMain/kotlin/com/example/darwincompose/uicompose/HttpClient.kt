package com.example.darwincompose.uicompose

import io.ktor.client.*
import io.ktor.client.engine.okhttp.*

actual val httpClient: HttpClient = HttpClient(OkHttp)