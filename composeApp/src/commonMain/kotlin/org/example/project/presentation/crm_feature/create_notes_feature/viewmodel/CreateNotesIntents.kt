package org.example.project.presentation.crm_feature.create_notes_feature.viewmodel

sealed class CreateNotesIntents {
    object Cancel: CreateNotesIntents()
    object Back: CreateNotesIntents()
    object Next: CreateNotesIntents()//(val title:String,val description:String,val status:String,val users:List<String>):CreateNotesIntents()
}