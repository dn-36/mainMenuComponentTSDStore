package org.example.project.crm_feature.create_bookmarks_screen.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import mainmenucomponenttsdstore.composeapp.generated.resources.Res
import mainmenucomponenttsdstore.composeapp.generated.resources.back
import org.jetbrains.compose.resources.painterResource
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.sp
import mainmenucomponenttsdstore.composeapp.generated.resources.down_arrow


object CreateBookmarksScreen:Screen{
    @Composable
    override fun Content() {
        var title by remember { mutableStateOf("") }
        var description by remember { mutableStateOf("") }
        var status by remember { mutableStateOf("") }
        var users by remember { mutableStateOf("") }

        var expandedStatus by remember { mutableStateOf(false) } // Состояние показа меню
        val listStatus = listOf("Скрыта","Активна")

        var expandedUsers by remember { mutableStateOf(false) } // Состояние показа меню
        val listUsers = listOf("John", "Emily", "Michael", "Sarah", "David")

        Box(modifier = Modifier.fillMaxSize().background(Color.White)){
        Column(modifier = Modifier.fillMaxSize().padding(16.dp)){
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(Res.drawable.back), contentDescription = null,
                    modifier = Modifier.size(20.dp)
                )
                Text("Редактирование заметки", fontSize = 20.sp, modifier = Modifier.padding(start = 40.dp))
            }
            Spacer(modifier = Modifier.height(20.dp))
            OutlinedTextField(
                value = title,
                onValueChange = {
                    title = it },
                label = { Text("Название") },
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = 40.dp) // Стандартная высота TextField
            )
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(
                value = status,
                onValueChange = {
                    status = it },
                label = { Text("Статус") },
                trailingIcon = {
                    IconButton(
                        onClick = { }
                    ) {
                        Icon(
                            painter = painterResource(Res.drawable.down_arrow),
                            contentDescription = "Поиск",
                            modifier = Modifier.size(20.dp)
                        )
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = 40.dp)
                    .clickable(
                        indication = null, // Отключение эффекта затемнения
                        interactionSource = remember { MutableInteractionSource() })
                    { expandedStatus = !expandedStatus }// Стандартная высота TextField
            )
            DropdownMenu(
                expanded = expandedStatus,
                onDismissRequest = { expandedStatus = false },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
            ) {
                // Генерация элементов списка
                listStatus.forEach { name ->
                    DropdownMenuItem(onClick = {
                        status = name // При выборе имя устанавливается в TextField
                        expandedStatus = false // Закрываем меню
                    }) {
                        Text(text = name)
                    }
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(
                value = users,
                onValueChange = {
                    users = it },
                label = { Text("Пользователи") },
                trailingIcon = {
                    IconButton(
                        onClick = { }
                    ) {
                        Icon(
                            painter = painterResource(Res.drawable.down_arrow),
                            contentDescription = "Поиск",
                            modifier = Modifier.size(20.dp)
                        )
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = 40.dp)
                    .clickable(
                        indication = null, // Отключение эффекта затемнения
                        interactionSource = remember { MutableInteractionSource() })
                    { expandedUsers = !expandedUsers}// Стандартная высота TextField
            )
            DropdownMenu(
                expanded = expandedUsers,
                onDismissRequest = { expandedUsers = false },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
            ) {
                // Генерация элементов списка
                listUsers.forEach { name ->
                    DropdownMenuItem(onClick = {
                        users = name // При выборе имя устанавливается в TextField
                        expandedUsers = false // Закрываем меню
                    }) {
                        Text(text = name)
                    }
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(
                value = description,
                onValueChange = {
                    description = it },
                label = { Text("Описание") },
                modifier = Modifier.fillMaxWidth()
                    .fillMaxHeight(0.3f) // Стандартная высота TextField
            )

            Spacer(modifier = Modifier.height(10.dp))


        }
            Row(modifier = Modifier.fillMaxWidth(0.95f)
                .align(Alignment.BottomCenter).padding(bottom = 16.dp)
                .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween){
                Button(
                    onClick = {  },
                    modifier = Modifier
                        .clip(RoundedCornerShape(70.dp))
                        .height(40.dp)
                        .fillMaxWidth(0.45f)
                ) {
                    Text(text = "Отменить")
                }
                Button(
                    onClick = {  },
                    modifier = Modifier
                        .clip(RoundedCornerShape(70.dp))
                        .height(40.dp)
                        .fillMaxWidth(0.9f)
                ) {
                    Text(text = "Продолжить")
                }
            }
        }
    }
}