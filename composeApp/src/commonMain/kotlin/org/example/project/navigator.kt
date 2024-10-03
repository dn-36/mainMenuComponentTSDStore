package org.example.project

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.Navigator
import org.example.project.presentation.menu_feature.screen.MenuScreen

object Navigation {
    lateinit var navigator: Navigator
    @Composable
    fun navigator() {
        Navigator(screen = MenuScreen)
    }
}


