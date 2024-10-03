package org.example.project.presentation.notes_feature.viewmodel

import com.project.core.model.NoteResponse

data class NotesState(
    val listNotes:List<NoteResponse> = listOf()
)
