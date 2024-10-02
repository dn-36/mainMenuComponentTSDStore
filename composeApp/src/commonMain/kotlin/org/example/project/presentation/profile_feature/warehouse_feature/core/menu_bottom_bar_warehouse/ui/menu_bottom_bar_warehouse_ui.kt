package org.example.project.core.menu_bottom_bar.ui

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
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
import mainmenucomponenttsdstore.composeapp.generated.resources.Res
import mainmenucomponenttsdstore.composeapp.generated.resources.exchange
import mainmenucomponenttsdstore.composeapp.generated.resources.printing
import mainmenucomponenttsdstore.composeapp.generated.resources.user
import mainmenucomponenttsdstore.composeapp.generated.resources.warehouse
import org.example.project.presentation.profile_feature.core.menu_bottom_bar_profile.viewmodel.MenuBottomBarWarehouseIntents
import org.example.project.presentation.profile_feature.core.menu_bottom_bar_profile.viewmodel.MenuBottomBarWarehouseViewModel


import org.jetbrains.compose.resources.painterResource

object MenuBottomBarWarehouse {

val vm = MenuBottomBarWarehouseViewModel()

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
                        Box(modifier = Modifier.clip(RoundedCornerShape(50.dp)).background(color = vm.menuBottomBarWarehouseState.colorListBottomMenu[0])
                            .width(70.dp).height(40.dp).clickable { vm.processIntent(MenuBottomBarWarehouseIntents.Warehouse) }){
                        Image(painter = painterResource(Res.drawable.warehouse),contentDescription = null,
                            modifier =  Modifier.size(30.dp).align(Alignment.Center))
                        }
                        Text("Склад", color = Color.Black, fontSize = 12.sp)

                    }
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Box(modifier = Modifier.clip(RoundedCornerShape(50.dp)).background(color = vm.menuBottomBarWarehouseState.colorListBottomMenu[1])
                            .width(70.dp).height(40.dp).clickable { vm.processIntent(MenuBottomBarWarehouseIntents.Finance)}){
                            Image(painter = painterResource(Res.drawable.exchange),contentDescription = null,
                                modifier =  Modifier.size(30.dp).align(Alignment.Center))
                        }
                        Text("Приход Расход", color = Color.Black, fontSize = 12.sp)

                    }
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Box(modifier = Modifier.clip(RoundedCornerShape(50.dp)).background(color = vm.menuBottomBarWarehouseState.colorListBottomMenu[2])
                            .width(70.dp).height(40.dp).clickable { vm.processIntent(MenuBottomBarWarehouseIntents.Print) }){
                            Image(painter = painterResource(Res.drawable.printing),contentDescription = null,
                                modifier =  Modifier.size(30.dp).align(Alignment.Center))
                        }
                        Text("Напечатать", color = Color.Black, fontSize = 12.sp)

                    }
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Box(modifier = Modifier.clip(RoundedCornerShape(50.dp)).background(color = vm.menuBottomBarWarehouseState.colorListBottomMenu[3])
                            .width(70.dp).height(40.dp).clickable { vm.processIntent(MenuBottomBarWarehouseIntents.Profile) }){
                            Image(painter = painterResource(Res.drawable.user),contentDescription = null,
                                modifier =  Modifier.size(30.dp).align(Alignment.Center))
                        }
                        Text("Профиль", color = Color.Black, fontSize = 12.sp)

                    }

                }
            }
    }
}
