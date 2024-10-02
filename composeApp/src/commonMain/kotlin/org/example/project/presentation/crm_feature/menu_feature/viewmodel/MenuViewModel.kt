package org.example.project.presentation.crm_feature.menu_feature.viewmodel

import androidx.lifecycle.ViewModel
import org.example.project.core.navigation.Navigation
import org.example.project.presentation.crm_feature.notes_feature.screen.NotesScreen

class MenuViewModel:ViewModel() {

    fun processIntent(intent: MenuIntents){
        when(intent){

            is MenuIntents.ClickedBookmarks -> {clickBookmarksIntent()}

        }
    }

    fun clickBookmarksIntent(){
        Navigation.navigator.push(NotesScreen)

    }

}