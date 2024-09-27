package org.example.project.core

import io.ktor.client.*
import io.ktor.client.call.body
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.logging.SIMPLE
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.json
import io.ktor.util.InternalAPI
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import org.example.project.core.model.Note
import org.example.project.core.model.NoteResponse


expect val httpClientEngine: HttpClientEngine

object NotesApi {
    var token: String = ""
    private val client = HttpClient(httpClientEngine) {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true // Игнорировать неизвестные поля
                isLenient = true // Быть гибким с форматом JSON
            })
        }
        install(Logging) {
            level = LogLevel.BODY // Включить логирование для отладки
        }
        defaultRequest {
            header("Authorization", "Bearer $token")
        }
    }

    // Получение списка заметок
    suspend fun getNotes(): List<NoteResponse> {


        val response = client.get("https://delta.online/api/notes") {
            parameter("active", 1)
        // для получения принятых пользователем заметок
        }
        println(" ////////////////////++++++++++")
        println(" ${response}")
        println(" ////////////////////++++++++++")
        return response.body<List<NoteResponse>>()
    }

    // Добавление новой заметки
    suspend fun createNote(note: Note): HttpResponse {
        return client.post("https://delta.online/api/notes") {
            contentType(ContentType.Application.Json)  // Установка типа контента
            setBody(note)
        }
    }

    // Обновление заметки
    // Обновление заметки
    suspend fun updateNote(noteId: String, updatedNote:  BodyNoteDto): HttpResponse {
      /*  val newNote = BodyNoteDto(name = "Test Note", text = "This is a test.", status = 0, users = listOf(1, 5), local_id = "1")
        val noteService = NoteServiceImpl(client)
        val createdNote = noteService.create(ConstData.TOKEN, newNote)
        val updatedNote = noteService.update(ConstData.TOKEN, createdNote.ui, newNote)*/
        println("////////////////////////////////////////")
       // println("Updating Note at: https://delta.online/api/notes/?id=$noteId")
        return try {
            val response = client.put("https://delta.online/api/notes/6834") {
                contentType(ContentType.Application.Json) // Установка типа контента
               // name = "Test Note", text = "This is a test.", status = 0, users = listOf(1, 5), local_id = "1")
            }
            println(" ${response.toString()} ")
            response
        } catch (e: Exception) {
            println("UPDATE Note: Error - ${e.message}")
            throw e // Или обработайте ошибку по-другому
        }
    }

    // Принять заметку
    suspend fun acceptNote(noteId: String): HttpResponse {
        return client.post("https://delta.online/api/notes-active-view/$noteId")
    }

    // Удаление заметки
    suspend fun deleteNote(noteId: String): HttpResponse {
        return client.delete("https://delta.online/api/notes/$noteId")
    }

    // Закрытие HTTP-клиента
    fun close() {
        client.close()
    }



}

interface NoteService {
    suspend fun getAllNotes(token: String): List<NoteDto>
    suspend fun create(token: String, dto: BodyNoteDto): NoteDto
    suspend fun update(token: String, uid: String, dto: BodyNoteDto): NoteDto
    suspend fun apply(token: String, uid: String)
    suspend fun delete(token: String, uid: String)
}

class NoteServiceImpl(private val client: HttpClient) : NoteService {
    override suspend fun getAllNotes(token: String): List<NoteDto> {
        return client.get("https://delta.online/api/notes") {
            header(HttpHeaders.Authorization, "Bearer $token")
        }.body()
    }

    @OptIn(InternalAPI::class)
    override suspend fun create(token: String, dto: BodyNoteDto): NoteDto {
        return client.post("https://delta.online/api/notes") {
            header(HttpHeaders.Authorization, "Bearer $token")
            contentType(ContentType.Application.Json)
            body = dto
        }.body()
    }

    @OptIn(InternalAPI::class)
    override suspend fun update(token: String, uid: String, dto: BodyNoteDto): NoteDto {
        return client.put("https://delta.online/api/notes/$uid") {
            header(HttpHeaders.Authorization, "Bearer $token")
            contentType(ContentType.Application.Json)
            body = dto
        }.body()
    }

    override suspend fun apply(token: String, uid: String) {
        client.post("https://delta.online/api/notes-active-view/$uid") {
            header(HttpHeaders.Authorization, "Bearer $token")
        }
    }

    override suspend fun delete(token: String, uid: String) {
        client.delete("https://delta.online/api/notes/$uid") {
            header(HttpHeaders.Authorization, "Bearer $token")
        }
    }
}

@Serializable
data class BodyNoteDto(
    val name: String?,
    val text: String?,
    val status: Int?,
    val users: List<Int>?,
    val local_id: String?
)

@kotlinx.serialization.Serializable
data class NoteDto(
    val active: Int?,
    val creator: Int?,
    val id: Int,
    val color: String?,
    val name: String?,
    val sort: Int?,
    val status: Int?,
    val text: String?,
    val ui: String,
    val users: List<UserDto>?,
    val view: Int?
)

@kotlinx.serialization.Serializable
data class UserDto(
    val id: Int,
    val name: String
)


/*

val client = HttpClient {
    install(ContentNegotiation) {
        json() // Используем Kotlinx.serialization для работы с JSON
    }
    install(Logging) {
        logger = Logger.SIMPLE
        level = LogLevel.BODY
    }
}
 */




