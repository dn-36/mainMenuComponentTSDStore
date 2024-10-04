package com.project.menu

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import com.project.chats.ChatsScreen
import com.project.core.menu_bottom_bar.ui.MenuBottomBar
import com.project.menu.screen.MenuScreen
import com.project.tape.TapeScreen
import org.example.project.presentation.notes_feature.screen.NotesScreen
import org.example.project.presentation.profile_feature.main_feature.screen.ProfileScreen

class HomeScreen(): Screen {
    @Composable
    override fun Content() {
        Box(modifier = Modifier.fillMaxSize().background(Color.White)){
            Column(modifier = Modifier.padding(16.dp),) {
                Text("Организации", color = Color.Black, fontSize = 20.sp)
            }
            Box(modifier = Modifier.align(Alignment.BottomCenter)) {
                MenuBottomBar().init(
                    this@HomeScreen,
                    MenuScreen(),
                    TapeScreen,
                    ChatsScreen,
                    ProfileScreen
                ) .Content()
            }
        }
    }
}