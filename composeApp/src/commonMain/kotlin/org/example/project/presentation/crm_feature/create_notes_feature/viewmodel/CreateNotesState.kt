package org.example.project.presentation.crm_feature.create_notes_feature.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import org.example.project.core.model.User

data class CreateNotesState(
    val name:String = "",
    val status:String = "",
    val users:String = "",
    val description:String = "",
    val listAllUsers:List<User> = listOf(),
    val expandedUsers:Boolean = false,
    val expandedStatus:Boolean = false,
    val usersNoteCreated:MutableList<Int> = mutableListOf<Int>(),
    val isUsed: MutableState<Boolean> = mutableStateOf(true)
)
