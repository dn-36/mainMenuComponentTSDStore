package org.example.project.presentation.crm_feature.edit_note_feature.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import org.example.project.core.model.Note

data class EditNoteState(
    val note: Note = Note(name = null,text = null,status = null,users = listOf(),local_id = "null"),
    val isUsed:MutableState<Boolean> = mutableStateOf(true),
    val noteText: String? = "",
    val expandedSettings:Boolean = false,
    val settingsName:Int = 0,
    val expandedList:Boolean = false,
    val alphaMainBox:MutableState<Float> = mutableStateOf(1f),
    val alphaModel:MutableState<Float> = mutableStateOf(0f),
    val text:String? = "",
    val openWindowUpdate:MutableState<Boolean> = mutableStateOf(false),
    val categoryNow:Int = 5,
    val users:MutableList<String?> = mutableListOf()
)
