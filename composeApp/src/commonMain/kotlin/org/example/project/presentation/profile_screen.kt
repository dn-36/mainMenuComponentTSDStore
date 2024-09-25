package org.example.project.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import mainmenucomponenttsdstore.composeapp.generated.resources.Res
import mainmenucomponenttsdstore.composeapp.generated.resources.down_arrow
import mainmenucomponenttsdstore.composeapp.generated.resources.photo_profie
import mainmenucomponenttsdstore.composeapp.generated.resources.user
import org.example.project.core.menu_bottom_bar.ui.MenuBottomBar
import org.jetbrains.compose.resources.painterResource

object ProfileScreen:Screen{
    @Composable
    override fun Content() {
        Box(modifier = Modifier.fillMaxSize().background(Color.LightGray)){
                Box(
                    modifier = Modifier.fillMaxWidth()
                        .fillMaxHeight(0.2f).background(Color.White))
            Column {
                Box(
                    modifier = Modifier.fillMaxWidth().fillMaxHeight(0.45f)
                        .clip(RoundedCornerShape(15.dp)).background(Color.White)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text("Профиль", color = Color.Black, fontSize = 20.sp)

                        Spacer(modifier = Modifier.height(30.dp))

                        Column(horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.fillMaxWidth()) {
                            Text("Name", fontSize = 20.sp)

                            Spacer(modifier = Modifier.height(8.dp))

                            Text("+8999999999", fontSize = 15.sp, color = Color.LightGray)

                            Spacer(modifier = Modifier.height(8.dp))

                            Image(
                                painter = painterResource(Res.drawable.photo_profie),
                                contentDescription = null,
                                modifier = Modifier.size(130.dp)
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
                Box(
                    modifier = Modifier.fillMaxWidth().fillMaxHeight(0.95f)
                        .clip(RoundedCornerShape(15.dp)).background(Color.White)
                ) {
                    Column(modifier = Modifier.padding(16.dp).align(Alignment.TopCenter)
                        , horizontalAlignment = Alignment.CenterHorizontally) {
                        Row(modifier = Modifier.fillMaxWidth(0.9f)
                        , horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically){
                            Text("Контроль проектов", fontSize = 15.sp)
                            Image(painter = painterResource(Res.drawable.down_arrow),contentDescription = null,
                                modifier = Modifier.size(20.dp).graphicsLayer(rotationZ = 270f))
                        }
                        Spacer(modifier = Modifier.height(20.dp))

                        Row(modifier = Modifier.fillMaxWidth(0.9f)
                            , horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically){
                            Text("Склад", fontSize = 15.sp)
                            Image(painter = painterResource(Res.drawable.down_arrow),contentDescription = null,
                                modifier = Modifier.size(20.dp).graphicsLayer(rotationZ = 270f))
                        }
                        Spacer(modifier = Modifier.height(20.dp))

                        Row(modifier = Modifier.fillMaxWidth(0.9f)
                            , horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically){
                            Text("О приложении", fontSize = 15.sp)
                            Image(painter = painterResource(Res.drawable.down_arrow),contentDescription = null,
                                modifier = Modifier.size(20.dp).graphicsLayer(rotationZ = 270f))
                        }
                    }
                }
            }
            Box(
                modifier = Modifier.align(Alignment.BottomCenter).fillMaxWidth()
                    .fillMaxHeight(0.2f).background(Color.White))
            Column(modifier = Modifier.align(Alignment.BottomCenter), horizontalAlignment = Alignment.CenterHorizontally) {
                Button(
                    onClick = {  },
                    modifier = Modifier
                        .clip(RoundedCornerShape(50.dp))
                        .height(40.dp)
                        .fillMaxWidth(0.9f)
                ) {
                    Text(text = "Выйти из профиля")
                }
                Spacer(modifier = Modifier.height(10.dp))

                Box() {
                    MenuBottomBar.Content()
                }
            }

        }
    }
}