package org.example.project.core.key_value_storage

interface  KeyValueStorage {
    suspend fun saveCurrentNumber(key: String, value: String)
    suspend fun getCurrentNumber(key: String): String?
    suspend fun saveCurrentName(key: String, value: String)
    suspend fun getCurrentName(key: String): String?
}

expect fun keyValueStorage () : KeyValueStorage

