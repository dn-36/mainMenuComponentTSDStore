package org.example.project.crm_feature.create_bookmarks_screen.viewmodel

import androidx.lifecycle.ViewModel
import org.example.project.core.StaticDate
import org.example.project.crm_feature.bookmarks_feature.screen.BookmarksScreen
import org.example.project.crm_feature.bookmarks_feature.viewmodel.BookmarksIntents
import org.example.project.crm_feature.utils.BookmarksData

class CreateBookmarksViewModel():ViewModel() {

    fun processIntent(intents: CreateBookmarksIntents){
        when(intents){
            is CreateBookmarksIntents.Next -> {next(intents.title,intents.status,intents.users,intents.description)}
            is CreateBookmarksIntents.Cancel -> {cancel()}
        }
    }
    fun next(title:String,status:String,users:List<String>,description:String){
    StaticDate.listBookmarks.add(BookmarksData(title = title,status = status,users = users,
        description = description))
}
    fun cancel(){
        StaticDate.navigator.push(BookmarksScreen)
    }
}