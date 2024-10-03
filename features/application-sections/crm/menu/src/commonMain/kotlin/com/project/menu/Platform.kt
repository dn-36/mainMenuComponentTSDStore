package com.project.menu

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform