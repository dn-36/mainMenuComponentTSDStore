package org.example.project.core.model

import kotlinx.serialization.Serializable


@Serializable
data class Note(
    val id: String?,
    val name: String?,
    val text: String?,
    val status: Int?,
    val users: List<Int?>?,
    val local_id: String? // Идентификатор локализации
)