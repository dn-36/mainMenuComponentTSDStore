package com.project.core.menu_bottom_bar.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import cafe.adriel.voyager.core.screen.Screen
import com.project.core.Navigation

class MenuBottomBarViewModel(
    private val homeScreen: Screen,
    private val crmScreen: Screen,
    private val tapeScreen: Screen,
    private val chatsScreen: Screen,
    private val profileScreen: Screen
) : ViewModel() {

    var menuBottomBarState by mutableStateOf(MenuBottomBarState())

    fun processIntent(intent:MenuBottomBarIntents){
        when(intent){
            is MenuBottomBarIntents.CRM -> {crm()}
            is MenuBottomBarIntents.Profile -> {profile()}
            is MenuBottomBarIntents.Chats -> {chats()}
            is MenuBottomBarIntents.Tape -> {tape()}
            is MenuBottomBarIntents.Home -> {home()}
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
        Navigation.navigator.push(crmScreen)

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
        Navigation.navigator.push(profileScreen)

    }

    fun home() {
        val newList = mutableListOf(
            Color(0xFFFF9800),
            Color.Transparent,
            Color.Transparent,
            Color.Transparent,
            Color.Transparent)

        menuBottomBarState = menuBottomBarState.copy(
            colorListBottomMenu = newList
        )
       Navigation.navigator.push(homeScreen)

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
        Navigation.navigator.push(chatsScreen)

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
        Navigation.navigator.push(tapeScreen)

    }
}