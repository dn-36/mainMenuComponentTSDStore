package org.example.project.presentation.edit_note_feature.viewmodel

import com.project.core.model.NoteResponse
import com.project.core.model.User
import kotlinx.coroutines.CoroutineScope
sealed class EditNoteIntents {
    data class SetScreen(val note: NoteResponse, val coroutineScope: CoroutineScope):EditNoteIntents()
    data class UpdateNoteBack(val note: NoteResponse, val coroutineScope: CoroutineScope):EditNoteIntents()

   // object Back:EditNoteIntents()
    object Cancel:EditNoteIntents()
    data class ApplyNameUpdate(val note: NoteResponse, val coroutineScope: CoroutineScope):EditNoteIntents()
    data class ApplyStatusUpdate(val note: NoteResponse, val coroutineScope: CoroutineScope):EditNoteIntents()
    data class ApplyUsersUpdate(val note: NoteResponse, val coroutineScope: CoroutineScope):EditNoteIntents()
    data class DeleteUserNote(val user: User):EditNoteIntents()
    data class DeleteNote(val note: NoteResponse,val coroutineScope: CoroutineScope):EditNoteIntents()
    data class SelectingEditableCategory(val index:Int):EditNoteIntents()
}