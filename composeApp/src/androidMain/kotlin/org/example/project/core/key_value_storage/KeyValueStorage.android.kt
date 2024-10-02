package org.example.project.core.key_value_storage

actual class KeyValueStorage {
    actual suspend fun saveCurrentNumber(key: String, value: String) {
    }

    actual suspend fun getCurrentNumber(key: String): String? {
        TODO("Not yet implemented")
    }
}