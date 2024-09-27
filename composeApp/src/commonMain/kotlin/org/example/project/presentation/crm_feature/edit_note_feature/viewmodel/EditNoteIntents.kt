package org.example.project.presentation.crm_feature.edit_note_feature.viewmodel

import org.example.project.core.model.NoteResponse

sealed class EditNoteIntents {
    data class SetScreen(val note: NoteResponse):EditNoteIntents()
    data class UpdateNote(val note: NoteResponse,val text:String?):EditNoteIntents()
    object Back:EditNoteIntents()
    object Cancel:EditNoteIntents()
    object Apply:EditNoteIntents()
    data class SelectingEditableCategory(val index:Int):EditNoteIntents()
}