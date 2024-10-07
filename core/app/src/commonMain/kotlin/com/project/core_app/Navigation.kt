package com.project.core

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.Navigator

object Navigation {
    lateinit var navigator: Navigator
    @Composable
    fun navigator(screen: Screen) {
        Navigator(screen = screen)
    }
}


/*
     implementation(project(":features:application-sections:crm:menu"))
            implementation(project(":features:application-sections:chat:chats"))
            implementation(project(":features:application-sections:crm:create_notes"))
            implementation(project(":features:application-sections:crm:edit_note"))
            implementation(project(":features:application-sections:crm:notes"))
            implementation(project(":features:application-sections:crm:project_conterol"))
            implementation(project(":features:application-sections:profile:profile"))
            implementation(project(":features:application-sections:tape:tape"))
 */