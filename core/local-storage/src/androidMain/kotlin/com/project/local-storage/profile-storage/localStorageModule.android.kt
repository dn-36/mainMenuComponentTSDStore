package com.project.`local-storage`.`profile-storage`

import com.project.`local-storage`.`outhorization-storage`.AuthorizationStorage
import org.koin.core.module.Module
import org.koin.dsl.module

actual val localStorageModule: Module
    get() = module {
        single {
            StorageAndroid(get()) as KeyValueStorageApi
        }
        single {
                AuthorizationStorage(get())
        }

    }