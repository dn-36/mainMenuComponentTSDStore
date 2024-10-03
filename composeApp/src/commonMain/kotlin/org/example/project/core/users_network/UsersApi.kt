package org.example.project.core.users_network

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.example.project.core.httpClientEngine
import org.example.project.core.model.User
import org.example.project.core.notes_network.NotesApi

object UsersApi {

   /* var token: String = ""

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
            header("Authorization", "Bearer ${token}")
        }
    }
    //получение имен всех пользовтелей
    suspend fun getUsers(): List<User> {

        val response = client.get("https://delta.online/api/users-company") {

        }
        println(" ////////////////////++++++++++")
        println(" ${response}")
        println(" ////////////////////++++++++++")
        return response.body<List<User>>()
    }*/
}