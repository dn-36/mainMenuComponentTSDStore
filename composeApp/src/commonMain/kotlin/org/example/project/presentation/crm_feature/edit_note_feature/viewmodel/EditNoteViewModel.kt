package org.example.project.presentation.crm_feature.edit_note_feature.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.example.project.core.ConstData
import org.example.project.core.Navigation
import org.example.project.core.model.Note
import org.example.project.core.model.NoteResponse
import org.example.project.core.NotesApi
import org.example.project.core.model.BodyNoteDto
import org.example.project.core.model.User
import org.example.project.presentation.crm_feature.notes_feature.screen.NotesScreen

class EditNoteViewModel : ViewModel() {
    var editNoteState by mutableStateOf(EditNoteState())


    fun processIntent(intent: EditNoteIntents) {
        when (intent) {
            is EditNoteIntents.SetScreen -> {
                setScreen(intent.note,intent.coroutineScope)
            }

            is EditNoteIntents.UpdateNote -> {
                updateNote(intent.note, intent.text,intent.coroutineScope)
            }

            is EditNoteIntents.Apply -> {
                apply(intent.note,intent.coroutineScope)
            }

            is EditNoteIntents.Cancel -> {
                cancel()
            }

            is EditNoteIntents.SelectingEditableCategory -> {
                selectingEditableCategory(intent.index)
            }

            is EditNoteIntents.DeleteNote -> {
                deleteNote(intent.note,intent.coroutineScope)
            }

            is EditNoteIntents.ApplyStatus -> {
                applyStatus(intent.note,intent.coroutineScope)
            }
        }
    }


    fun selectingEditableCategory(index: Int) {
        editNoteState = editNoteState.copy(
            isUsed = mutableStateOf(true),
            openWindowUpdate = true,
            categoryNow = index)
    }

    fun cancel() {
        editNoteState = editNoteState.copy(
            openWindowUpdate = false
        )
    }

    fun applyStatus(note: NoteResponse,coroutineScope: CoroutineScope) {

        val token = ConstData.TOKEN

        val notesApi = NotesApi
        NotesApi.token = token

        val idUsers = mutableListOf<Int?>()

        editNoteState.updatedUser.forEach { it ->
            println("${it.name}")
            idUsers.add(it.id)
        }

        println("${idUsers}")

        var status = 1

        when(editNoteState.text) {

            "Активна" -> {status = 1}

            "Скрыта" -> {status = 0}

        }

        val updatedNote = BodyNoteDto(
            name = note.name,
            text = editNoteState.noteText,
            status = status,
            users = idUsers.toList(),
            local_id = "null")

        editNoteState = editNoteState.copy(
            openWindowUpdate = false,
            status = status
        )

        println("2")
        println("2")
        println("2")
        println("${updatedNote}")
        println("2")
        println("2")

        coroutineScope.launch(Dispatchers.IO) {
            notesApi.updateNote(noteId = "${note.ui}", updatedNote = updatedNote)
        }
    }

    fun apply(note: NoteResponse,coroutineScope: CoroutineScope) {

        editNoteState = editNoteState.copy(
            openWindowUpdate = false
        )
        val token = ConstData.TOKEN

        val notesApi = NotesApi
        NotesApi.token = token

        val idUsers = mutableListOf<Int?>()

        note.users.forEach { it ->
            println("${it.name}")
            idUsers.add(it.id)
        }

        /*editNoteState.updatedUser.forEach { it ->
            println("${it.name}")
            idUsers.add(it.id)
        }*/

        println("${idUsers}")

        val updatedNote = BodyNoteDto(
            name = editNoteState.title,
            text = editNoteState.noteText,
            status = note.status,
            users = idUsers.toList(),
            local_id = "null"
        )

        println("2")
        println("2")
        println("2")
        println("${idUsers}")
        println("2")
        println("2")

        coroutineScope.launch(Dispatchers.IO) {
            notesApi.updateNote(noteId = "${note.ui}", updatedNote = updatedNote)
        }
    }

    fun setScreen(note: NoteResponse,coroutineScope: CoroutineScope) {

        if (editNoteState.isUsed.value) {

            editNoteState.isUsed.value = false

            coroutineScope.launch(Dispatchers.IO) {

            val idUsers = mutableListOf<Int?>()

            val updatedUsers = mutableListOf<User>()

                val token = ConstData.TOKEN

                val notesApi = NotesApi
                NotesApi.token = token

            note.users.forEach { it ->
                idUsers.add(it.id)
                updatedUsers.add(it)
            }

            val allUsers = mutableListOf<User>()

                notesApi.getUsers().forEach {
                    allUsers.add(it)
                }

            var userText = mutableStateOf<String?>("")

            val status = when (note.status) {
                1 -> "Активна"
                0 -> "Скрыта"
                else -> {
                    ""
                }
            }

            note.users.forEach { it ->
                println("${it.name}")
                //users.add(it)
                userText.value = "${userText.value + it.name},"
            }

            println("${userText.value}")

                /*val text = when (editNoteState.categoryNow) {
                    0 -> status
                    1 -> note.name
                   // 1 -> userText.value
                    else -> {
                        ""
                    }
                }*/

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
                listAllUsers = allUsers,
                text = status,
                title = note.name,
                status = note.status,
                updatedUser = updatedUsers
            )

            println("5")
            println("5")
            println("5")
            println("${editNoteState.text}")
            println("5")
            println("5")
            println("5")
        }
            }
    }

    fun updateNote(note: NoteResponse, text: String?,coroutineScope: CoroutineScope) {


        val idUsers = mutableListOf<Int?>()

        editNoteState.updatedUser.forEach { it ->
            idUsers.add(it.id)
        }


        val token = ConstData.TOKEN

        val notesApi = NotesApi

        NotesApi.token = token

        val updatedNote = BodyNoteDto(
            name = editNoteState.title,
            text = text,
            status = editNoteState.status,
            users = idUsers,
            local_id = "null"
        )

        println("2")
        println("2")
        println("2")
        println("${updatedNote}")
        println("2")
        println("2")

        coroutineScope.launch(Dispatchers.IO) {

            notesApi.updateNote(noteId = "${note.ui}", updatedNote = updatedNote)

                Navigation.navigator.push(NotesScreen)

        }
    }

    fun deleteNote(note: NoteResponse,coroutineScope: CoroutineScope) {

        val token = ConstData.TOKEN

        val notesApi = NotesApi
        NotesApi.token = token

        coroutineScope.launch(Dispatchers.IO) {

            notesApi.deleteNote(noteId = "${note.ui}")

            Navigation.navigator.push(NotesScreen)

        }

    }

}