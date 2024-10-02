package org.example.project.presentation.profile_feature.main_feature.viewmodel

import kotlinx.coroutines.CoroutineScope
import org.example.project.core.key_value_storage.KeyValueStorage

sealed class ProfileIntents {
    object Warehouse:ProfileIntents()

    data class SetScreen(val coroutineScope: CoroutineScope):ProfileIntents()
}