package com.profile.profile

import com.project.chats.ProfileScreensApi
import org.koin.dsl.module

val profileScreensModule = module {
   factory {
    ProfileScreensImpl() as ProfileScreensApi
   }
}