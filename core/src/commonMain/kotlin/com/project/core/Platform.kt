package com.project.core

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform