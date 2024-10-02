package org.example.project.core.key_value_storage

import platform.Foundation.NSUserDefaults


class IOSKeyValueStorage : KeyValueStorage{

    private val userDefaults = NSUserDefaults.standardUserDefaults

    override suspend fun saveCurrentNumber(key: String, value: String) {
        userDefaults.setObject(value, forKey = key)
    }

    override suspend fun saveCurrentName(key: String, value: String) {
        userDefaults.setObject(value, forKey = key)
    }

    override suspend fun getCurrentNumber(key: String): String? {
        return userDefaults.stringForKey(key)
    }

    override suspend fun getCurrentName(key: String): String? {
        return userDefaults.stringForKey(key)
    }
}
actual fun keyValueStorage(): KeyValueStorage = IOSKeyValueStorage()