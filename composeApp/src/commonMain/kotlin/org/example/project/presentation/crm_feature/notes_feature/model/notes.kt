package org.example.project.presentation.crm_feature.notes_feature.model

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.material.Text
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.sp


object Bookmarks{
    @Composable
    fun Content(title:String){
    Box(){
        Card(modifier = Modifier.height(80.dp).width(170.dp).shadow(elevation = 8.dp, shape = RoundedCornerShape(8.dp)),
            backgroundColor = Color.White,
            shape = RoundedCornerShape(8.dp)) {}
        Text(title, fontSize = 15.sp, modifier = Modifier.padding(10.dp))
    }
    }
}