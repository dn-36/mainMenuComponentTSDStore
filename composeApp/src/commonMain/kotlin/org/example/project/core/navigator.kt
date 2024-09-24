package org.example.project.core

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import org.example.project.crm_feature.menu_feature.screen.MenuScreen

@Composable
fun navigator(){
    Navigator(screen = MenuScreen)
}