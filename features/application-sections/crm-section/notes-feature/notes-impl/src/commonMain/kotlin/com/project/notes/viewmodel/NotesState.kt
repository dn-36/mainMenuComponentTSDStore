package com.project.notes.viewmodel

import com.project.core.model.NoteResponse

data class NotesState(
    val listNotes:List<NoteResponse> = listOf()
)
