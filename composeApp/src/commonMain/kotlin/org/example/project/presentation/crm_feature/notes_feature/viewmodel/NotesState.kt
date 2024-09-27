package org.example.project.presentation.crm_feature.notes_feature.viewmodel

import org.example.project.core.model.NoteResponse

data class NotesState(
    val listNotes:List<NoteResponse> = listOf()
)
