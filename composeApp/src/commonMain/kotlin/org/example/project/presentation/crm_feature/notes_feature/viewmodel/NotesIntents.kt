package org.example.project.presentation.crm_feature.notes_feature.viewmodel

import org.example.project.core.model.NoteResponse

sealed class NotesIntents {
    object CreateBookmarks: NotesIntents()
    object SetNotes: NotesIntents()
    data class EditNote(val note: NoteResponse): NotesIntents()
}