package com.project.notes.viewmodel

import com.project.core.model.NoteResponse
import kotlinx.coroutines.CoroutineScope

sealed class NotesIntents {
    object CreateBookmarks: NotesIntents()
    data class SetNotes (val coroutineScope: CoroutineScope): NotesIntents()
    data class EditNote(val note: NoteResponse): NotesIntents()
}