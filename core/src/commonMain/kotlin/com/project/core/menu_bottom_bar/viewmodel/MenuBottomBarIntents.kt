package com.project.core.menu_bottom_bar.viewmodel

sealed class MenuBottomBarIntents {
    object CRM:MenuBottomBarIntents()
    object Profile:MenuBottomBarIntents()
    object Home:MenuBottomBarIntents()
    object Chats:MenuBottomBarIntents()
    object Tape:MenuBottomBarIntents()
}