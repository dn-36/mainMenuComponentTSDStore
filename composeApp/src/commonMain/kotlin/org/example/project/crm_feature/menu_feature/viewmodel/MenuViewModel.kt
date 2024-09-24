package org.example.project.crm_feature.menu_feature.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import org.example.project.core.StaticDate
import org.example.project.crm_feature.bookmarks_feature.screen.BookmarksScreen

class MenuViewModel:ViewModel() {

        var menuState by mutableStateOf(MenuState())


    fun processIntent(intent:MenuIntents){
        when(intent){
            is MenuIntents.ClickedHome -> {clickedHomeIntent()}
            is MenuIntents.ClickedProfile -> {clickedProfileIntent()}
            is MenuIntents.ClickedMenu -> {clickedMenuIntent()}
            is MenuIntents.ClickedChats -> {clickedChatsIntent()}
            is MenuIntents.ClickedBookmarks -> {clickedBookmarksIntent()}
        }
    }

    fun clickedHomeIntent(){
    val newList = mutableListOf(Color(0xFFD18E2B),Color.Transparent,Color.Transparent,Color.Transparent,Color.Transparent)

    menuState = menuState.copy(
        colorListBottomMenu = newList
    )
    }
    fun clickedBookmarksIntent(){
        StaticDate.navigator.push(BookmarksScreen)

    }
    fun clickedMenuIntent(){
        val newList = mutableListOf(Color.Transparent,Color.Transparent,Color(0xFFD18E2B),Color.Transparent,Color.Transparent)

        menuState = menuState.copy(
            colorListBottomMenu = newList
        )
    }
    fun clickedChatsIntent(){
        val newList = mutableListOf(Color.Transparent,Color.Transparent,Color.Transparent,Color(0xFFD18E2B),Color.Transparent)

        menuState = menuState.copy(
            colorListBottomMenu = newList
        )
    }
    fun clickedProfileIntent(){
        val newList = mutableListOf(Color.Transparent,Color.Transparent,Color.Transparent,Color.Transparent,Color(0xFFD18E2B))

        menuState = menuState.copy(
            colorListBottomMenu = newList
        )
    }

}