package org.example.project.presentation.chats_feature.model

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import mainmenucomponenttsdstore.composeapp.generated.resources.Res
import mainmenucomponenttsdstore.composeapp.generated.resources.chats_ava
import org.jetbrains.compose.resources.painterResource

object ChatsItem{
    @Composable
    fun Content(){
        Box(modifier = Modifier.fillMaxWidth(0.95f)){
            Row(modifier = Modifier.fillMaxWidth()){
                Image(painter = painterResource(Res.drawable.chats_ava),contentDescription = null,
                    modifier = Modifier.size(50.dp))
                Column(){
                 Text(text = "Название чата", fontSize = 20.sp)
                 Text(text = "последнее сообщение", fontSize = 13.sp, color = Color(0x00707575))
                }
            }
        }
    }
}