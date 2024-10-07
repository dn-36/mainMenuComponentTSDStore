package com.project.core

import com.project.core.key_value_storage.KeyValueStorage
import com.project.core.key_value_storage.StorageAndroid
import org.koin.core.module.Module
import org.koin.dsl.module

actual val coreModule: Module
    get() = module {
        single {
            StorageAndroid(get()) as KeyValueStorage
        }
    }