package org.example.project.presentation.crm_feature.edit_note_feature.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch
import org.example.project.core.ConstData
import org.example.project.core.Navigation
import org.example.project.core.model.Note
import org.example.project.core.model.NoteResponse
import org.example.project.core.NotesApi
import org.example.project.core.model.BodyNoteDto
import org.example.project.presentation.crm_feature.notes_feature.screen.NotesScreen

class EditNoteViewModel : ViewModel() {
    var editNoteState by mutableStateOf(EditNoteState())


    fun processIntent(intent: EditNoteIntents) {
        when (intent) {
            is EditNoteIntents.SetScreen -> {
                setScreen(intent.note)
            }

            is EditNoteIntents.UpdateNote -> {
                updateNote(intent.note, intent.text)
            }

            is EditNoteIntents.Back -> {
                back()
            }

            is EditNoteIntents.Apply -> {
                apply()
            }

            is EditNoteIntents.Cancel -> {
                cancel()
            }

            is EditNoteIntents.SelectingEditableCategory -> {
                selectingEditableCategory(intent.index)
            }

            is EditNoteIntents.DeleteNote -> {
                deleteNote(intent.note)
            }
        }
    }


    fun selectingEditableCategory(index: Int) {
        editNoteState = editNoteState.copy(
            openWindowUpdate = mutableStateOf(true),
            categoryNow = index,
            isUsed = mutableStateOf(true)
        )
    }

    fun cancel() {
        editNoteState = editNoteState.copy(
            openWindowUpdate = mutableStateOf(false)
        )
    }

    fun apply() {
        editNoteState = editNoteState.copy(
            openWindowUpdate = mutableStateOf(false)
        )
    }

    fun setScreen(note: NoteResponse) {

        if (editNoteState.isUsed.value) {

            editNoteState.isUsed.value = false

            val idUsers = mutableListOf<Int?>()
            note.users.forEach { it ->
                idUsers.add(it.id)
            }

            val usersName = mutableListOf<String?>("")
            note.users.forEach { it ->
                usersName[0] += it.name + "\n"
            }

            val users = mutableListOf<String?>()
            note.users.forEach { it ->
                users.add(it.name)
            }

            val status = when (note.status) {
                1 -> "Активна"
                0 -> "Скрыта"
                else -> {
                    ""
                }
            }


            editNoteState = editNoteState.copy(
                note = Note(
                   // id = "note.id",
                    name = note.name,
                    text = note.text,
                    status = note.status,
                    users = idUsers.toList(),
                    local_id = "${note.id}"
                ),
                noteText = note.text,
                users = users,
                text = when (editNoteState.categoryNow) {
                     0 -> status
                     1 -> usersName[0]
                    else -> {
                        ""
                    }
                }
            )
            println("5")
            println("5")
            println("5")
            println("${editNoteState.users}")
            println("5")
            println("5")
            println("5")
        }
    }

    fun updateNote(note: NoteResponse, text: String?) {

        val token = ConstData.TOKEN

        val notesApi = NotesApi
        NotesApi.token = token
        val idUsers = mutableListOf<Int?>()
        note.users.forEach { it ->
            idUsers.add(it.id)
        }

        val updatedNote = BodyNoteDto(
            name = note.name,
            text = text,
            status = note.status,
            users = listOf(),
            local_id = "null"
        )

        println("2")
        println("2")
        println("2")
        println("${updatedNote}")
        println("2")
        println("2")

        CoroutineScope(Dispatchers.IO).launch {
            notesApi.updateNote(noteId = "${note.ui}", updatedNote = updatedNote)
        }
    }

    fun deleteNote(note: NoteResponse) {

        val token = ConstData.TOKEN

        val notesApi = NotesApi
        NotesApi.token = token

        CoroutineScope(Dispatchers.IO).launch {
            notesApi.deleteNote(noteId = "${note.ui}")
        }

        Navigation.navigator.push(NotesScreen)
    }

    fun back(){
        Navigation.navigator.push(NotesScreen)
    }
}