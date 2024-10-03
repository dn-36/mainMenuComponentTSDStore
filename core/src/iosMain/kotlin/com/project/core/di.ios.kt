package com.project.core

import com.project.core.key_value_storage.StorageIos
import org.koin.core.module.Module
import org.koin.dsl.module

actual val coreModule: Module
    get() = module{
       single {
           StorageIos()
       }

    }