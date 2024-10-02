package org.example.project.core.key_value_storage

import android.content.Context
import org.example.project.MainActivity


class AndroidKeyValueStorage() : KeyValueStorage {

    private val sharedPreferences = MainActivity.context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)

     override suspend fun saveCurrentNumber(key: String, value: String) {
        sharedPreferences.edit().putString(key, value).apply()
    }

     override suspend fun saveCurrentName(key: String, value: String) {
        sharedPreferences.edit().putString(key, value).apply()
    }

     override suspend fun getCurrentNumber(key: String): String? {
        return sharedPreferences.getString(key, null)
    }

     override suspend fun getCurrentName(key: String): String? {
        return sharedPreferences.getString(key, null)
    }
}

actual fun keyValueStorage(): KeyValueStorage = AndroidKeyValueStorage()