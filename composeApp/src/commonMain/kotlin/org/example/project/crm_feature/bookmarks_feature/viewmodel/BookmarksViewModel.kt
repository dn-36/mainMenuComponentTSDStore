package org.example.project.crm_feature.bookmarks_feature.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import org.example.project.core.StaticDate
import org.example.project.crm_feature.create_bookmarks_screen.screen.CreateBookmarksScreen

class BookmarksViewModel:ViewModel() {
    var bookmarksState by mutableStateOf(BookmarksState())
    fun processIntent(intents: BookmarksIntents){
        when(intents){
            is BookmarksIntents.CreateBookmarks -> {createBookmarks()}
        }
    }
    fun createBookmarks(){
        StaticDate.navigator.push(CreateBookmarksScreen)
    }
}