package org.example.project.core

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import org.example.project.presentation.crm_feature.menu_feature.screen.MenuScreen

object Navigation {
    lateinit var navigator: Navigator
    @Composable
    fun navigator() {
        Navigator(screen = MenuScreen)
    }
}
/*suspend fun getNotes(active: Int): Result<List<Note>, NetworkError> {
        val response = try {
            httpClient.get("https://delta.online/api/notes") {
                header("Authorization", "Bearer $authToken")
                parameter("active", active)
            }
        } catch (e: UnresolvedAddressException) {
            return Result.Error(NetworkError.NO_INTERNET)
        } catch (e: SerializationException) {
            return Result.Error(NetworkError.SERIALIZATION)
        }

        return when (response.status.value) {
            in 200..299 -> {
                val notes = response.body<List<Note>>() // Десериализуем ответ
                Result.Success(notes)
            }
            401 -> Result.Error(NetworkError.UNAUTHORIZED)
            in 500..599 -> Result.Error(NetworkError.SERVER_ERROR)
            else -> Result.Error(NetworkError.UNKNOWN)
        }
    }*/