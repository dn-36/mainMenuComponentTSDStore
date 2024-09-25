package org.example.project.presentation.crm_feature.create_notes_feature.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch
import org.example.project.core.Navigation
import org.example.project.presentation.crm_feature.notes_feature.screen.NotesScreen
import org.example.project.presentation.crm_feature.utils.BookmarksData

class CreateNotesViewModel():ViewModel() {

    var createNotesState by mutableStateOf(CreateNotesState())

    fun processIntent(intents: CreateNotesIntents){
        when(intents){
            is CreateNotesIntents.Next -> {next()
                //next(intents.title,intents.status,intents.users,intents.description)
            }
            is CreateNotesIntents.Cancel -> {cancel()}
            is CreateNotesIntents.Back -> {back()}
        }
    }
    fun next(//title:String,status:String,users:List<String>,description:String
    ){
        Navigation.navigator.push(NotesScreen)
}
    fun cancel(){
        Navigation.navigator.push(NotesScreen)
    }
    fun back(){
        Navigation.navigator.push(NotesScreen)
    }
}