package com.project.notes.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.project.core.ConstData
import com.project.core.Navigation
import com.project.core.model.NoteResponse
import com.project.core.model.removeHtmlTags
import com.project.core.notes_network.NotesApi
import com.project.create_notes.screen.CreateNotesScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch
import org.example.project.presentation.edit_note_feature.screen.EditNoteScreen

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

            // Проходим по каждому элементу списка и очищаем поле text от HTML-тегов
            val cleanedNotesResponse = notesResponse.map { note ->
                note.copy(text = note.text?.let { removeHtmlTags(it) })  // Удаляем HTML-теги из текста
            }

            notesState = notesState.copy(

                listNotes = cleanedNotesResponse

            )

            println("${notesResponse}")

        }

    }
}