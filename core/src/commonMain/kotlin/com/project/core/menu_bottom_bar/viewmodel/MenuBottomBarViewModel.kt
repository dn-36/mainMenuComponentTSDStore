package com.project.core.menu_bottom_bar.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel

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
      //  Navigation.navigator.push(MenuScreen)

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
       // Navigation.navigator.push(ProfileScreen)

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
       // Navigation.navigator.push(HomeScreen)

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
      //  Navigation.navigator.push(ChatsScreen)

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
        //Navigation.navigator.push(TapeScreen)

    }
}