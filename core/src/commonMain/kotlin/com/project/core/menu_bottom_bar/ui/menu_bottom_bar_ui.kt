package com.project.core.menu_bottom_bar.ui

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import com.project.core.menu_bottom_bar.viewmodel.MenuBottomBarIntents
import com.project.core.menu_bottom_bar.viewmodel.MenuBottomBarViewModel
import mainmenucomponenttsdstore.core.generated.resources.Res
import mainmenucomponenttsdstore.core.generated.resources.home
import mainmenucomponenttsdstore.core.generated.resources.menu
import mainmenucomponenttsdstore.core.generated.resources.messenger
import mainmenucomponenttsdstore.core.generated.resources.squares_stack
import mainmenucomponenttsdstore.core.generated.resources.user


import org.jetbrains.compose.resources.painterResource
//http\\:delta.com?parametr=bjdbdjj&kfdjkdf=ghghjhcndfknf
class MenuBottomBar {
   private var vm:MenuBottomBarViewModel? = null

    fun init(
        home:Screen,
        crm:Screen,
        tape:Screen,
        chats:Screen,
        profile:Screen
    ):MenuBottomBar{
        vm = MenuBottomBarViewModel(
            home,
            crm,
            tape,
            chats,
            profile
        )
        return this
    }

    @Composable
     fun Content() {




            Box(
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    .fillMaxHeight(0.1f)
                    .fillMaxWidth()
                    .background(Color.White)
            ) {
                Row(modifier = Modifier.align(Alignment.BottomCenter)
                    .fillMaxWidth(0.95f), horizontalArrangement = Arrangement.SpaceBetween){
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Box(modifier = Modifier.clip(RoundedCornerShape(50.dp)).background(color = vm!!.menuBottomBarState.colorListBottomMenu[0])
                            .width(70.dp).height(40.dp).clickable { vm!!.processIntent(MenuBottomBarIntents.Home) }){
                        Image(painter = painterResource(Res.drawable.home),contentDescription = null,
                            modifier =  Modifier.size(30.dp).align(Alignment.Center))
                        }
                        Text("Организа...", color = Color.Black, fontSize = 12.sp)

                    }
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Box(modifier = Modifier.clip(RoundedCornerShape(50.dp)).background(color = vm!!.menuBottomBarState.colorListBottomMenu[1])
                            .width(70.dp).height(40.dp).clickable { vm!!.processIntent(
                                MenuBottomBarIntents.CRM)}){
                            Image(painter = painterResource(Res.drawable.squares_stack),contentDescription = null,
                                modifier =  Modifier.size(30.dp).align(Alignment.Center))
                        }
                        Text("CRM", color = Color.Black, fontSize = 12.sp)

                    }
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Box(modifier = Modifier.clip(RoundedCornerShape(50.dp)).background(color = vm!!.menuBottomBarState.colorListBottomMenu[2])
                            .width(70.dp).height(40.dp).clickable { vm!!.processIntent(MenuBottomBarIntents.Tape) }){
                            Image(painter = painterResource(Res.drawable.menu),contentDescription = null,
                                modifier =  Modifier.size(30.dp).align(Alignment.Center))
                        }
                        Text("Лента", color = Color.Black, fontSize = 12.sp)

                    }
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Box(modifier = Modifier.clip(RoundedCornerShape(50.dp)).background(color = vm!!.menuBottomBarState.colorListBottomMenu[3])
                            .width(70.dp).height(40.dp).clickable { vm!!.processIntent(MenuBottomBarIntents.Chats) }){
                            Image(painter = painterResource(Res.drawable.messenger),contentDescription = null,
                                modifier =  Modifier.size(30.dp).align(Alignment.Center))
                        }
                        Text("Чаты", color = Color.Black, fontSize = 12.sp)

                    }
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Box(modifier = Modifier.clip(RoundedCornerShape(50.dp)).background(color = vm!!.menuBottomBarState.colorListBottomMenu[4])
                            .width(70.dp).height(40.dp).clickable { vm!!.processIntent(MenuBottomBarIntents.Profile) }){
                            Image(painter = painterResource(Res.drawable.user),contentDescription = null,
                                modifier =  Modifier.size(30.dp).align(Alignment.Center))

                        }
                        Text("Профиль", color = Color.Black, fontSize = 12.sp)

                    }
                }
            }
    }
}
