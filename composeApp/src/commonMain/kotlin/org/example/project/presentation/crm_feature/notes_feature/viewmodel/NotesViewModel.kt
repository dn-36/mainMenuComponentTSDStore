package org.example.project.presentation.crm_feature.notes_feature.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import org.example.project.core.Navigation
import org.example.project.presentation.crm_feature.create_notes_feature.screen.CreateNotesScreen

class NotesViewModel:ViewModel() {
    var notesState by mutableStateOf(NotesState())
    fun processIntent(intents: NotesIntents){
        when(intents){
            is NotesIntents.CreateBookmarks -> {createBookmarks()}
        }
    }
    fun createBookmarks(){
        Navigation.navigator.push(CreateNotesScreen)
    }
}