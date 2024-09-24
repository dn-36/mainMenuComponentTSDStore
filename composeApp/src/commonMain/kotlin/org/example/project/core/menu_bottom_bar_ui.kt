package org.example.project.core

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
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
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import mainmenucomponenttsdstore.composeapp.generated.resources.Res
import mainmenucomponenttsdstore.composeapp.generated.resources.crm
import mainmenucomponenttsdstore.composeapp.generated.resources.home
import mainmenucomponenttsdstore.composeapp.generated.resources.menu
import mainmenucomponenttsdstore.composeapp.generated.resources.messenger
import mainmenucomponenttsdstore.composeapp.generated.resources.user


import org.jetbrains.compose.resources.painterResource

object MenuBottomBar {

    @Composable
     fun Content(colorList:List<Color>,onClickHome:()->Unit,onClickCRM:()->Unit,
                 onClickMenu:()->Unit,onClickChats:()->Unit,onClickProfile:()->Unit,) {
            Box(
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    .fillMaxHeight(0.2f)
                    .fillMaxWidth()
                    .background(Color.White)
            ) {
                Row(modifier = Modifier.align(Alignment.BottomCenter)
                    .fillMaxWidth(0.95f), horizontalArrangement = Arrangement.SpaceBetween){
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Box(modifier = Modifier.clip(RoundedCornerShape(50.dp)).background(color = colorList[0])
                            .width(70.dp).height(40.dp).clickable { onClickHome() }){
                        Image(painter = painterResource(Res.drawable.home),contentDescription = null,
                            modifier =  Modifier.size(30.dp).align(Alignment.Center))
                        }
                        Text("Организа...", color = Color.Black, fontSize = 12.sp)

                    }
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Box(modifier = Modifier.clip(RoundedCornerShape(50.dp)).background(color = colorList[1])
                            .width(70.dp).height(40.dp).clickable { onClickCRM()}){
                            Image(painter = painterResource(Res.drawable.crm),contentDescription = null,
                                modifier =  Modifier.size(30.dp).align(Alignment.Center))
                        }
                        Text("CRM", color = Color.Black, fontSize = 12.sp)

                    }
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Box(modifier = Modifier.clip(RoundedCornerShape(50.dp)).background(color = colorList[2])
                            .width(70.dp).height(40.dp).clickable { onClickMenu() }){
                            Image(painter = painterResource(Res.drawable.menu),contentDescription = null,
                                modifier =  Modifier.size(30.dp).align(Alignment.Center))
                        }
                        Text("Лента", color = Color.Black, fontSize = 12.sp)

                    }
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Box(modifier = Modifier.clip(RoundedCornerShape(50.dp)).background(color = colorList[3])
                            .width(70.dp).height(40.dp).clickable { onClickChats() }){
                            Image(painter = painterResource(Res.drawable.messenger),contentDescription = null,
                                modifier =  Modifier.size(30.dp).align(Alignment.Center))
                        }
                        Text("Чаты", color = Color.Black, fontSize = 12.sp)

                    }
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Box(modifier = Modifier.clip(RoundedCornerShape(50.dp)).background(color = colorList[4])
                            .width(70.dp).height(40.dp).clickable { onClickProfile() }){
                            Image(painter = painterResource(Res.drawable.user),contentDescription = null,
                                modifier =  Modifier.size(30.dp).align(Alignment.Center))

                        }
                        Text("Профиль", color = Color.Black, fontSize = 12.sp)

                    }
                }
            }
    }
}
