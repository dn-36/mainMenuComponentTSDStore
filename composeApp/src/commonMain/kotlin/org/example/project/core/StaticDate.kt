package org.example.project.core

import cafe.adriel.voyager.navigator.Navigator
import org.example.project.crm_feature.bookmarks_feature.model.Bookmarks
import org.example.project.crm_feature.utils.BookmarksData
//Убрать StaticData
object StaticDate {
    lateinit var navigator: Navigator
    var listBookmarks:MutableList<BookmarksData> = mutableListOf()
}