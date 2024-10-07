package org.example.project

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import com.project.menu.screen.OrganizationScreenApi
import com.project.navigation.Navigation
import org.koin.mp.KoinPlatform.getKoin

@Composable
fun App() {
    val homeSreen: OrganizationScreenApi = getKoin().get()
    MaterialTheme {
        Navigation.navigator(homeSreen.organization())
    }
}

