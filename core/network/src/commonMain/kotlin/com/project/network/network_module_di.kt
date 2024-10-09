package com.project.network

import com.project.network.authorization_network.AuthorizationClient
import org.koin.dsl.module

val network_module = module {
   factory {
       httpClientEngine
   }
    factory {
        AuthorizationClient(get())
    }
}