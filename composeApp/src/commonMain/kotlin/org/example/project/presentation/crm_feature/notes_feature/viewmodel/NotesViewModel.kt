package org.example.project.presentation.crm_feature.notes_feature.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch
import org.example.project.core.ConstData
import org.example.project.core.Navigation
import org.example.project.core.model.NoteResponse
import org.example.project.core.NotesApi
import org.example.project.presentation.crm_feature.create_notes_feature.screen.CreateNotesScreen
import org.example.project.presentation.crm_feature.edit_note_feature.screen.EditNoteScreen

class NotesViewModel:ViewModel() {
    var notesState by mutableStateOf(NotesState())
    fun processIntent(intents: NotesIntents){
        when(intents){
            is NotesIntents.CreateBookmarks -> {createNotesIntent()}
            is NotesIntents.SetNotes -> {setNotesIntent(intents.coroutineScope)}
            is NotesIntents.EditNote -> {editNote(intents.note)}
        }
    }
    fun createNotesIntent(){
        Navigation.navigator.push(CreateNotesScreen)
    }
    fun editNote(note: NoteResponse){
        Navigation.navigator.push(EditNoteScreen(note))
    }
    fun setNotesIntent(coroutineScope: CoroutineScope){
        val token = ConstData.TOKEN
        NotesApi.token = token
        val notesApi = NotesApi
        coroutineScope.launch(Dispatchers.IO) {
            val notesResponse = notesApi.getNotes()
            notesState = notesState.copy(
                listNotes =notesResponse
            )
            println("${notesResponse}")
        }

    }
}