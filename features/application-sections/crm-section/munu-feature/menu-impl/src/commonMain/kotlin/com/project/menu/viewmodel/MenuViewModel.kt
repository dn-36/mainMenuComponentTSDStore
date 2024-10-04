package com.project.menu.viewmodel

import androidx.lifecycle.ViewModel
import com.project.core.Navigation
import org.example.project.presentation.menu_feature.viewmodel.MenuIntents

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