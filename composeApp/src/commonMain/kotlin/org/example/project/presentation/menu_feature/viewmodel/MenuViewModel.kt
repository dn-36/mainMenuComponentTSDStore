package org.example.project.presentation.menu_feature.viewmodel

import androidx.lifecycle.ViewModel
import org.example.project.Navigation
import org.example.project.presentation.notes_feature.screen.NotesScreen

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