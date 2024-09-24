package org.example.project.crm_feature.menu_feature.viewmodel

sealed class MenuIntents {
    object ClickedHome:MenuIntents()
    //object ClickedCRM:CRMIntents()
    object ClickedMenu:MenuIntents()
    object ClickedChats:MenuIntents()
    object ClickedProfile:MenuIntents()
    object ClickedBookmarks:MenuIntents()
}