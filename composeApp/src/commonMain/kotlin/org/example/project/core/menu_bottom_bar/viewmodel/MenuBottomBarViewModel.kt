package org.example.project.core.menu_bottom_bar.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import org.example.project.presentation.chats_feature.ChatsScreen
import org.example.project.presentation.HomeScreen
import org.example.project.presentation.profile_feature.main_feature.screen.ProfileScreen
import org.example.project.presentation.TapeScreen
import org.example.project.core.navigation.Navigation
import org.example.project.presentation.crm_feature.menu_feature.screen.MenuScreen

class MenuBottomBarViewModel : ViewModel() {

    var menuBottomBarState by mutableStateOf(MenuBottomBarState())

    fun processIntent(intent:MenuBottomBarIntents){
        when(intent){
            is MenuBottomBarIntents.CRM -> {crm()}
            is MenuBottomBarIntents.Profile -> {profile()}
            is MenuBottomBarIntents.Chats -> {chats()}
            is MenuBottomBarIntents.Tape -> {tape()}
            is MenuBottomBarIntents.Organizations -> {organizations()}
        }
    }
    fun crm() {
        val newList = mutableListOf(
            Color.Transparent,
            Color(0xFFFF9800),
            Color.Transparent,
            Color.Transparent,
            Color.Transparent)

        menuBottomBarState = menuBottomBarState.copy(
            colorListBottomMenu = newList
        )
        Navigation.navigator.push(MenuScreen)

    }

    fun profile() {
        val newList = mutableListOf(
            Color.Transparent,
            Color.Transparent,
            Color.Transparent,
            Color.Transparent,
            Color(0xFFFF9800))

        menuBottomBarState = menuBottomBarState.copy(
            colorListBottomMenu = newList
        )
        Navigation.navigator.push(ProfileScreen)

    }

    fun organizations() {
        val newList = mutableListOf(
            Color(0xFFFF9800),
            Color.Transparent,
            Color.Transparent,
            Color.Transparent,
            Color.Transparent)

        menuBottomBarState = menuBottomBarState.copy(
            colorListBottomMenu = newList
        )
        Navigation.navigator.push(HomeScreen)

    }

    fun chats() {
        val newList = mutableListOf(
            Color.Transparent,
            Color.Transparent,
            Color.Transparent,
            Color(0xFFFF9800),
            Color.Transparent)

        menuBottomBarState = menuBottomBarState.copy(
            colorListBottomMenu = newList
        )
        Navigation.navigator.push(ChatsScreen)

    }

    fun tape() {
        val newList = mutableListOf(
            Color.Transparent,
            Color.Transparent,
            Color(0xFFFF9800),
            Color.Transparent,
            Color.Transparent)

        menuBottomBarState = menuBottomBarState.copy(
            colorListBottomMenu = newList
        )
        Navigation.navigator.push(TapeScreen)

    }
}