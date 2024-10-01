package org.example.project.presentation.crm_feature.edit_note_feature.viewmodel

import kotlinx.coroutines.CoroutineScope
import org.example.project.core.model.NoteResponse

sealed class EditNoteIntents {
    data class SetScreen(val note: NoteResponse,val coroutineScope: CoroutineScope):EditNoteIntents()
    data class UpdateNote(val note: NoteResponse,val text:String?,val coroutineScope: CoroutineScope):EditNoteIntents()

   // object Back:EditNoteIntents()
    object Cancel:EditNoteIntents()
    data class Apply(val note: NoteResponse,val coroutineScope: CoroutineScope):EditNoteIntents()
    data class ApplyStatus(val note: NoteResponse,val coroutineScope: CoroutineScope):EditNoteIntents()
    data class DeleteNote(val note: NoteResponse,val coroutineScope: CoroutineScope):EditNoteIntents()
    data class SelectingEditableCategory(val index:Int):EditNoteIntents()
}