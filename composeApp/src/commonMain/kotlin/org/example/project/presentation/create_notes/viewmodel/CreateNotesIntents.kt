package org.example.project.presentation.create_notes.viewmodel

import com.project.core.model.User
import kotlinx.coroutines.CoroutineScope

sealed class CreateNotesIntents {
    object Cancel: CreateNotesIntents()
    object Back: CreateNotesIntents()

    data class GetAllUsersList(val coroutineScope: CoroutineScope):CreateNotesIntents()
    data class Next(val coroutineScope: CoroutineScope):CreateNotesIntents()
    data class DeleteUserNote(val user: User):CreateNotesIntents()
}