package org.example.project.presentation.crm_feature.create_notes_feature.viewmodel

data class CreateNotesState(
    val title:String = "",
    val status:String = "",
    val user:String = "",
    val description:String = "",
    val expandedUsers:Boolean = false,
    val expandedStatus:Boolean = false,
    val listUsers:List<String> = listOf()
)
