package org.example.project.core.menu_bottom_bar.viewmodel

sealed class MenuBottomBarIntents {
    object CRM:MenuBottomBarIntents()
    object Profile:MenuBottomBarIntents()
    object Organizations:MenuBottomBarIntents()
    object Chats:MenuBottomBarIntents()
    object Tape:MenuBottomBarIntents()
}