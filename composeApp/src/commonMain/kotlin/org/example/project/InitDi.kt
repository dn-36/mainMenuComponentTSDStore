package org.example.project

import com.profile.profile.profileScreensModule
import com.project.chats.chatsModule
import com.project.core.coreModule
import com.project.core.key_value_storage.KeyValueStorage
import com.project.organizationScreenModule
import com.project.`menu-crm-impl`.menuCrmModule
import com.project.tape.tapeScreenModule
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

fun initKoin(config: KoinAppDeclaration? = null) {
    startKoin {
        config?.invoke(this)
        modules(
            chatsModule,
            organizationScreenModule,
            menuCrmModule,
            tapeScreenModule,
            profileScreensModule,
            coreModule
        )
    }
}

