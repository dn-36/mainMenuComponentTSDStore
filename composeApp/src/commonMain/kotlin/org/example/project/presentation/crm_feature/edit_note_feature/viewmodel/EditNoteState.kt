package org.example.project.presentation.crm_feature.edit_note_feature.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import org.example.project.core.model.Note

data class EditNoteState(
    val note: Note = Note(id = "",name = null,text = null,status = null,users = listOf(),local_id = "null"),
    val isUsed:MutableState<Boolean> = mutableStateOf(true),
    val noteText: String? = "",
    val expandedSettings:Boolean = false,
    val settingsName:Int = 0,
    val expandedList:Boolean = false,
    val text:String? = "",
    val openWindowUpdate:Boolean = false,
    val categoryNow:Int = 0,
    val users:MutableList<String?> = mutableListOf()
)
