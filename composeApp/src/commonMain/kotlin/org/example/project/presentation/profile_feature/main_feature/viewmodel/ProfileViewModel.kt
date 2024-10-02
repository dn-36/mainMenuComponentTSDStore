package org.example.project.presentation.profile_feature.main_feature.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch
import org.example.project.core.data.ConstData
import org.example.project.core.key_value_storage.KeyValueStorage
import org.example.project.core.key_value_storage.keyValueStorage
import org.example.project.core.navigation.Navigation
import org.example.project.core.notes_network.NotesApi
import org.example.project.core.users_network.UsersApi
import org.example.project.presentation.crm_feature.edit_note_feature.screen.EditNoteScreen
import org.example.project.presentation.profile_feature.warehouse_feature.main_feature.screen.WarehouseScreen

class ProfileViewModel:ViewModel() {

    var profileState by mutableStateOf(ProfileState())

    fun processIntent(intents: ProfileIntents){

        when(intents) {

            is ProfileIntents.Warehouse -> { warehouse() }

            is ProfileIntents.SetScreen -> { setScreen(intents.coroutineScope) }

        }
    }

    fun warehouse(){

        Navigation.navigator.push(WarehouseScreen)

    }

    fun setScreen(coroutineScope: CoroutineScope){

       val keyValueStorage:KeyValueStorage = keyValueStorage()

        if(profileState.isUsed.value) {

            profileState.isUsed.value = false

            val token = ConstData.TOKEN

            UsersApi.token = token

            val usersApi = UsersApi

            coroutineScope.launch(Dispatchers.IO) {

               // println("${usersApi.getUsers()}")

                keyValueStorage.saveCurrentNumber("currentNumber","+79963799050")

                keyValueStorage.saveCurrentName("currentName","DIMA")

                println("${keyValueStorage.getCurrentNumber("currentNumber")}")

            }
        }
    }
}