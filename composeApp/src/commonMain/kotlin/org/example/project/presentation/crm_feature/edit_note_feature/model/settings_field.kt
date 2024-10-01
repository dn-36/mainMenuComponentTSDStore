package org.example.project.presentation.crm_feature.edit_note_feature.model

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import mainmenucomponenttsdstore.composeapp.generated.resources.Res
import mainmenucomponenttsdstore.composeapp.generated.resources.down_arrow
import org.example.project.core.model.NoteResponse
import org.example.project.presentation.crm_feature.edit_note_feature.viewmodel.EditNoteIntents
import org.example.project.presentation.crm_feature.edit_note_feature.viewmodel.EditNoteViewModel
import org.jetbrains.compose.resources.painterResource

data class WindowUpdate(val vm: EditNoteViewModel,val noteResponse: NoteResponse) {

    var selectedUsers = vm.editNoteState.updatedUser

    @Composable
    fun Status() {

        val scope = rememberCoroutineScope()

        Box(modifier = Modifier.fillMaxSize()) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .alpha(0.6f)
                    .background(Color.Black)
            )
                Box(
                    modifier = Modifier.clip(RoundedCornerShape(20.dp))
                        .fillMaxWidth(0.85f).background(Color.White)
                        .align(Alignment.Center)
                ) {
                    Spacer(modifier = Modifier.height(10.dp))
                    Column(
                        modifier = Modifier.align(Alignment.Center),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                    OutlinedTextField(
                        value = vm.editNoteState.text!!,
                        onValueChange = {
                            vm.editNoteState = vm.editNoteState.copy(
                                text = it
                            )
                        },
                        label = { Text("Статус") },
                        trailingIcon = {
                            IconButton(
                                onClick = {
                                    vm.editNoteState = vm.editNoteState.copy(
                                        expandedList = !vm.editNoteState.expandedList
                                    )
                                }
                            ) {
                                Icon(
                                    painter = painterResource(Res.drawable.down_arrow),
                                    contentDescription = "Поиск",
                                    modifier = Modifier.size(20.dp)
                                )
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .heightIn(min = 40.dp)
                            .clickable(
                                indication = null, // Отключение эффекта затемнения
                                interactionSource = remember { MutableInteractionSource() })
                            { }// Стандартная высота TextField
                    )
                    if (vm.editNoteState.expandedList) {
                        Box(
                            modifier = Modifier.fillMaxWidth(0.8f).fillMaxHeight(0.2f)
                        ) {
                            Card(
                                modifier = Modifier.fillMaxSize()
                                    .shadow(elevation = 8.dp, shape = RoundedCornerShape(8.dp)),
                                backgroundColor = Color.White,
                                shape = RoundedCornerShape(8.dp)
                            ) {}
                            LazyColumn {
                                itemsIndexed(listOf("Активна", "Скрыта")) { index, item ->
                                    Text(item,
                                        fontSize = 15.sp,
                                        modifier = Modifier.fillMaxWidth(0.9f).padding(16.dp)
                                            .clickable(
                                                indication = null, // Отключение эффекта затемнения
                                                interactionSource = remember { MutableInteractionSource() })
                                            {
                                                vm.editNoteState = vm.editNoteState.copy(
                                                    text = item,
                                                    expandedList = false
                                                )
                                            })
                                }
                            }
                        }
                    }
                        Spacer(modifier = Modifier.height(10.dp))
                        Button(
                            onClick = {
                                println("проверяем знач")
                                println("проверяем знач")
                                println("${vm.editNoteState.text}")
                                println("проверяем знач")
                                println("проверяем знач")
                                vm.processIntent(EditNoteIntents.ApplyStatus(noteResponse,scope))},
                            modifier = Modifier
                                .clip(RoundedCornerShape(70.dp))
                                .height(40.dp)
                                .fillMaxWidth(0.8f)
                        ) {
                            Text(text = "Применить")
                        }
                        Spacer(modifier = Modifier.height(10.dp))
                }

            }
        }
    }
    @Composable
    fun Name() {

        val scope = rememberCoroutineScope()

        Box(modifier = Modifier.fillMaxSize()) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .alpha(0.6f)
                    .background(Color.Black)
            )
            Box(
                modifier = Modifier.clip(RoundedCornerShape(20.dp))
                    .fillMaxWidth(0.85f).background(Color.White)
                    .align(Alignment.Center)
            ) {
                Spacer(modifier = Modifier.height(10.dp))
                Column(
                    modifier = Modifier.align(Alignment.Center),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    OutlinedTextField(
                        value = vm.editNoteState.title!!,
                        onValueChange = {
                            vm.editNoteState = vm.editNoteState.copy(
                                title = it
                            )
                        },
                        label = { Text("Название") },
                        trailingIcon = {
                            IconButton(
                                onClick = {
                                    vm.editNoteState = vm.editNoteState.copy(
                                        expandedList = !vm.editNoteState.expandedList
                                    )
                                }
                            ) {
                                Icon(
                                    painter = painterResource(Res.drawable.down_arrow),
                                    contentDescription = "Поиск",
                                    modifier = Modifier.size(20.dp)
                                )
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .heightIn(min = 40.dp)
                            .clickable(
                                indication = null, // Отключение эффекта затемнения
                                interactionSource = remember { MutableInteractionSource() })
                            { }// Стандартная высота TextField
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Button(
                        onClick = {
                            println("проверяем знач")
                            println("проверяем знач")
                            println("${vm.editNoteState.text}")
                            println("проверяем знач")
                            println("проверяем знач")
                            vm.processIntent(EditNoteIntents.ApplyStatus(noteResponse,scope))},
                        modifier = Modifier
                            .clip(RoundedCornerShape(70.dp))
                            .height(40.dp)
                            .fillMaxWidth(0.8f)
                    ) {
                        Text(text = "Применить")
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                }

            }
        }
    }
   /* @Composable
    fun Users() {

        val scope = rememberCoroutineScope()

        println("users")
        println("users")
        println("${vm.editNoteState.text!!}")
        println("users")
        println("users")

        Box(modifier = Modifier.fillMaxSize()) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .alpha(0.6f)
                    //  .clickable { actionCloseSettings() }
                    .background(Color.Black)
            )
            Box(
                modifier = Modifier.clip(RoundedCornerShape(20.dp))
                    .fillMaxWidth(0.85f).background(Color.White)
                    .align(Alignment.Center)
            ) {
                Spacer(modifier = Modifier.height(10.dp))
                Column(
                    modifier = Modifier.align(Alignment.Center),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    OutlinedTextField(
                        value = vm.editNoteState.text!!,
                        onValueChange = {
                            vm.editNoteState = vm.editNoteState.copy(
                                text = it
                            )
                        },
                        label = { Text("Пользватели") },
                        trailingIcon = {
                            IconButton(
                                onClick = {
                                    vm.editNoteState = vm.editNoteState.copy(
                                        expandedList = !vm.editNoteState.expandedList
                                    )
                                }
                            ) {
                                Icon(
                                    painter = painterResource(Res.drawable.down_arrow),
                                    contentDescription = "Поиск",
                                    modifier = Modifier.size(20.dp)
                                )
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .heightIn(min = 40.dp)
                            .clickable(
                                indication = null, // Отключение эффекта затемнения
                                interactionSource = remember { MutableInteractionSource() })
                            { }// Стандартная высота TextField
                    )
                    if (vm.editNoteState.expandedList) {
                        Box(
                            modifier = Modifier.fillMaxWidth(0.8f).fillMaxHeight(0.2f)
                        ) {
                            Card(
                                modifier = Modifier.fillMaxSize()
                                    .shadow(elevation = 8.dp, shape = RoundedCornerShape(8.dp)),
                                backgroundColor = Color.White,
                                shape = RoundedCornerShape(8.dp)
                            ) {}
                            LazyColumn {
                                itemsIndexed(vm.editNoteState.listAllUsers) { index, item ->
                                    Text(item.name!!,
                                        fontSize = 15.sp,
                                        modifier = Modifier.fillMaxWidth(0.9f).padding(16.dp)
                                            .clickable(
                                                indication = null, // Отключение эффекта затемнения
                                                interactionSource = remember { MutableInteractionSource() })
                                            {
                                                selectedUsers.add(item)

                                                vm.editNoteState = vm.editNoteState.copy(
                                                    text =  "${vm.editNoteState.text + item.name},",
                                                    expandedList = false,
                                                    updatedUser = selectedUsers
                                                )
                                            })
                                }
                            }
                        }
                    }
                    println("333")
                    println("333")
                    println("${selectedUsers }")
                    println("333")
                    println("333")
                    Spacer(modifier = Modifier.height(10.dp))
                    Button(
                        onClick = {

                            vm.processIntent(EditNoteIntents.Apply(noteResponse,scope))},
                        modifier = Modifier
                            .clip(RoundedCornerShape(70.dp))
                            .height(40.dp)
                            .fillMaxWidth(0.8f)
                    ) {
                        Text(text = "Применить", modifier = Modifier.clickable(
                            indication = null, // Отключение эффекта затемнения
                            interactionSource = remember { MutableInteractionSource() })
                        {})
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                }

            }
        }
    }*/
    @Composable
    fun Delete() {

        val scope = rememberCoroutineScope()

        Box(modifier = Modifier.fillMaxSize()) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .alpha(0.6f)
                    //  .clickable { actionCloseSettings() }
                    .background(Color.Black)
            )
            Box(
                modifier = Modifier.clip(RoundedCornerShape(20.dp))
                    .fillMaxWidth(0.85f).background(Color.White)
                    .align(Alignment.Center)
            ) {
                Spacer(modifier = Modifier.height(10.dp))
                Column(
                    modifier = Modifier.padding(16.dp)
                        .align(Alignment.Center)
                ) {
                    Text("Удаление", fontSize = 12.sp)
                    Text("Вы действительно хотите удалить заметку?", fontSize = 12.sp)

                    Spacer(modifier = Modifier.height(25.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(0.8f),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Text("Удалить", fontSize = 12.sp, modifier = Modifier.clickable(
                            indication = null, // Отключение эффекта затемнения
                            interactionSource = remember { MutableInteractionSource() })
                        {vm.processIntent(EditNoteIntents.DeleteNote(noteResponse,scope))})
                        Text("Отмена", fontSize = 12.sp, modifier = Modifier.clickable(
                            indication = null, // Отключение эффекта затемнения
                            interactionSource = remember { MutableInteractionSource() })
                        {vm.processIntent(EditNoteIntents.Cancel)})
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
    }
}