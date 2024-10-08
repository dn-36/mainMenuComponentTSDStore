package org.example.project.core.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

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
