package org.example.project.presentation.crm_feature.create_notes_feature.viewmodel

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
import org.example.project.core.NotesApi
import org.example.project.core.model.Note
import org.example.project.presentation.crm_feature.notes_feature.screen.NotesScreen

class CreateNotesViewModel():ViewModel() {

    var createNotesState by mutableStateOf(CreateNotesState())

    fun processIntent(intents: CreateNotesIntents){
        when(intents){
            is CreateNotesIntents.Next -> {next(intents.coroutineScope)
            }
            is CreateNotesIntents.Cancel -> {cancel()}

            is CreateNotesIntents.Back -> {back()}

            is CreateNotesIntents.GetAllUsersList -> {getAllUsersList(intents.coroutineScope)}
        }
    }
    fun next(coroutineScope: CoroutineScope){

        val token = ConstData.TOKEN

        val notesApi = NotesApi

        NotesApi.token = token

        val statusInt = when(createNotesState.status){

            "Активна" -> { 1 }

            "Скрыта" -> { 0 }

            else -> { 1 }
        }

        coroutineScope.launch(Dispatchers.IO) {

            val note = Note(
                name = createNotesState.name,
                text = createNotesState.description,
                status = statusInt,
                users = createNotesState.usersNoteCreated,
                local_id = "9090")

            notesApi.createNote(note)

            Navigation.navigator.push(NotesScreen)

            createNotesState = createNotesState.copy(
                name = "",
                status = "",
                users = "",
                description = "",
                listAllUsers = listOf(),
                expandedUsers = false,
                expandedStatus = false,
                usersNoteCreated = mutableListOf(),
                isUsed = mutableStateOf(true)
            )
        }



}
    fun cancel(){
        Navigation.navigator.push(NotesScreen)
    }
    fun back(){
        Navigation.navigator.push(NotesScreen)
    }

    fun getAllUsersList(coroutineScope: CoroutineScope){

        if(createNotesState.isUsed.value) {

            createNotesState.isUsed.value = false

            val token = ConstData.TOKEN

            val notesApi = NotesApi

            NotesApi.token = token

            coroutineScope.launch(Dispatchers.IO) {

                createNotesState = createNotesState.copy(
                    listAllUsers = notesApi.getUsers()
                )
            }

            println("9:${createNotesState.listAllUsers}")

        }
    }
}