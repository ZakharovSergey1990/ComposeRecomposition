
package com.example.composerecomposition.page.fourth_tip_page

import androidx.compose.material.Scaffold
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.composerecomposition.model.User
import com.example.composerecomposition.ui_component.AppBar
import com.example.composerecomposition.ui_component.BasePage
import com.example.composerecomposition.ui_component.InfoDialog
import com.example.composerecomposition.constant.TipInfo
import kotlinx.collections.immutable.ImmutableList

@Composable
fun FourthTipPage(vm1: FourthPageViewModel = hiltViewModel(), vm2: FourthPageViewModel2 = hiltViewModel()) {
    InfoDialog(title = "Fourth tip information", info = TipInfo.FIRST_PAGE_INFO)
    Scaffold(topBar = {
        AppBar("Fourth Tip")
    }) {
        InfoDialog(title = "Fourth tip information" , info = TipInfo.FOURTH_PAGE_INFO)
        BasePage(
            wrongTabContent = {
                FourthTipWrongContent(vm1)
            },
            wrightTabContent = {
                FourthTipWrightContent(vm2)
            }
        )
    }
}


@Composable
fun FourthTipWrongContent(vm: FourthPageViewModel) {
    val users by vm.users.collectAsState()
    val color by vm.color.collectAsState()
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.background(color)){
        Button(onClick =  vm::changeColor , modifier = Modifier.fillMaxWidth(0.9f)) {
            Text("change color")
        }
        Users(users)
        }
    }



@Composable
fun FourthTipWrightContent(vm: FourthPageViewModel2) {
    val users by vm.users.collectAsState()
    val color by vm.color.collectAsState()
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.background(color)){
        Button(onClick =  vm::changeColor , modifier = Modifier.fillMaxWidth(0.9f)) {
            Text("change color")
        }
        Users2(users)
    }
}

@Composable
fun Users(users: List<User>) {
    users.forEach { user ->
            UserItem(user = user)
    }
}

@Composable
fun Users2(users: ImmutableList<User>) {
    users.forEach { user ->
        UserItem(user = user)
    }
}

@Composable
fun UserItem(user: User) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(0.9f)
    ) {
        Text(text = user.name)
        Text(text = user.id.toString())
    }
    Divider(modifier = Modifier.padding(16.dp))
}