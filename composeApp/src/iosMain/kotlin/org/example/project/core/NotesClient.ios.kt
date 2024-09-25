package org.example.project.core

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.ios.Ios

actual val httpClientEngine: HttpClientEngine
    get() =  Ios.create()