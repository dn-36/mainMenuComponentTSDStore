package org.example.project.core

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import org.example.project.presentation.crm_feature.menu_feature.screen.MenuScreen

object Navigation {
    lateinit var navigator: Navigator
    @Composable
    fun navigator() {
        Navigator(screen = MenuScreen)
    }
}
