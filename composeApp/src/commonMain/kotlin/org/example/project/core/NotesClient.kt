package org.example.project.core

import io.ktor.client.*
import io.ktor.client.call.body
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement


expect val httpClientEngine: HttpClientEngine

class NotesApi(private val token: String) {

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
        return  client.get("https://delta.online/api/notes") {
            parameter("active", 1)
        // для получения принятых пользователем заметок
        }.body<List<NoteResponse>>()
    }
    // Функция для выполнения GET запроса с заданными параметрами и извлечения полей name
    /*suspend fun getProductNames(): List<Product>{
        val url = "https://delta.online/api/products-filter"
        val products: ApiResponse = client.get(url) {
            parameter("cat", "0")
            parameter("active", "0")
            parameter("service", "2")
            parameter("sale", "true")
            parameter("order", "false")
            parameter("store", "false")
        }.body()
        return products.data?: listOf()//!!.map { it.name?:"" }
    }*/

    // Добавление новой заметки
    suspend fun createNote(note: Note): HttpResponse {
        return client.post("https://delta.online/api/notes") {
            contentType(ContentType.Application.Json)  // Установка типа контента
            setBody(note)
        }
    }

    // Обновление заметки
    suspend fun updateNote(noteId: String, updatedNote: Note): HttpResponse {
        return client.put("https://delta.online/api/notes/$noteId") {
            contentType(ContentType.Application.Json)  // Установка типа контента
            setBody(updatedNote)
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

@Serializable
data class NoteResponse(
    val active: Int?,
    val view: Int?,
    val fon: String?,
    val status: Int?,
    val creater: Int?,
    val sort: Int?,
    val ui: String?,
    val users: List<User>,
    val project: JsonElement? = null,
    val text: String?,
    val id: Int?,
    val name: String?,
    val user: User?,
    @SerialName("updated_at") val updatedAt: String?,
    @SerialName("open_link") val openLink: Int?,
    val chat: String? = null,
    @SerialName("count_new_message") val countNewMessage: Int?
)

@Serializable
data class User(
    val id: Int?,
    val name: String?,
    val email: String? = null,
    @SerialName("email_verified_at") val emailVerifiedAt: String? = null,
    val phone: String?,
    val ui: String?,
    val policy: Int?,
    @SerialName("created_at") val createdAt: String?,
    @SerialName("updated_at") val updatedAt: String?,
    val tema: String?,
    val active: Int?,
    val inn: String? = null,
    val image: String? = null,
    val contragents: Int?,
    val price: Int? = null,
    @SerialName("lang_id") val langId: Int?
)

@Serializable
data class Note(
    val name: String?,
    val text: String?,
    val status: Int?,
    val users: List<Int>?,
    val local_id: String?
)