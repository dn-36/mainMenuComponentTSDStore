package org.example.project.crm_feature.create_bookmarks_screen.viewmodel

sealed class CreateBookmarksIntents {
    object Cancel:CreateBookmarksIntents()
    data class Next(val title:String,val description:String,
                      val status:String,val users:List<String>):CreateBookmarksIntents()
}