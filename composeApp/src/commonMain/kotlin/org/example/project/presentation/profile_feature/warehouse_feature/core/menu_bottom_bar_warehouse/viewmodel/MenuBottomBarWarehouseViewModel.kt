package org.example.project.presentation.profile_feature.core.menu_bottom_bar_profile.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import org.example.project.presentation.HomeScreen
import org.example.project.presentation.TapeScreen
import org.example.project.core.navigation.Navigation
import org.example.project.presentation.crm_feature.menu_feature.screen.MenuScreen
import org.example.project.presentation.profile_feature.main_feature.screen.ProfileScreen
import org.example.project.presentation.profile_feature.warehouse_feature.finance_feature.screen.FinanceScreen
import org.example.project.presentation.profile_feature.warehouse_feature.main_feature.screen.WarehouseScreen

class MenuBottomBarWarehouseViewModel : ViewModel() {

    var menuBottomBarWarehouseState by mutableStateOf(MenuBottomBarWarehouseState())

    fun processIntent(intent: MenuBottomBarWarehouseIntents){
        when(intent){
            is MenuBottomBarWarehouseIntents.Finance -> { finance() }

            is MenuBottomBarWarehouseIntents.Print -> { print() }

            is MenuBottomBarWarehouseIntents.Warehouse -> { warehouse() }

            is MenuBottomBarWarehouseIntents.Profile -> { profile() }
        }
    }

    fun warehouse() {
        val newList = mutableListOf(
            Color(0xFFFF9800),
            Color.Transparent,
            Color.Transparent,
            Color.Transparent)

        menuBottomBarWarehouseState = menuBottomBarWarehouseState.copy(
            colorListBottomMenu = newList
        )
        Navigation.navigator.push(WarehouseScreen)

    }

    fun finance() {
        val newList = mutableListOf(
            Color.Transparent,
            Color(0xFFFF9800),
            Color.Transparent,
            Color.Transparent)

        menuBottomBarWarehouseState = menuBottomBarWarehouseState.copy(
            colorListBottomMenu = newList
        )
        Navigation.navigator.push(FinanceScreen)

    }

    fun print() {
        val newList = mutableListOf(
            Color.Transparent,
            Color.Transparent,
            Color(0xFFFF9800),
            Color.Transparent)

        menuBottomBarWarehouseState = menuBottomBarWarehouseState.copy(
            colorListBottomMenu = newList
        )
        Navigation.navigator.push(WarehouseScreen)

    }

    fun profile() {
        val newList = mutableListOf(
            Color.Transparent,
            Color.Transparent,
            Color.Transparent,
            Color(0xFFFF9800))

        menuBottomBarWarehouseState = menuBottomBarWarehouseState.copy(
            colorListBottomMenu = newList
        )
        Navigation.navigator.push(ProfileScreen)

    }

}