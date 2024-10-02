package org.example.project.core.key_value_storage

expect class KeyValueStorage {
    suspend fun saveCurrentNumber(key: String, value: String)
    suspend fun getCurrentNumber(key: String): String?
}

