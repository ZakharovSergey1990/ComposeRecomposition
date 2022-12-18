package com.example.composerecomposition.page.second_tip_page

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.composerecomposition.model.User
import com.example.composerecomposition.ui_component.BasePage
import androidx.compose.material.Scaffold
import com.example.composerecomposition.ui_component.AppBar
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.Text
import com.example.composerecomposition.ui_component.InfoDialog
import com.example.composerecomposition.constant.TipInfo

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SecondTipPage(vm: SecondPageViewModel = hiltViewModel()) {
    Scaffold(topBar = {
        AppBar("Second Tip")
    }) {
        InfoDialog(title = "Second tip information", info = TipInfo.SECOND_PAGE_INFO)
        BasePage(
            wrongTabContent = {
                SecondTipWrongContent(vm)
            },
            wrightTabContent = {
                SecondTipWrightContent(vm)
            }
        )
    }
}


@Composable
fun SecondTipWrongContent(vm: SecondPageViewModel) {
    val users by vm.users.collectAsState()
    Column(horizontalAlignment = Alignment.CenterHorizontally){
        Button(onClick =  vm::mixUsers , modifier = Modifier.fillMaxWidth(0.9f)) {
            Text("mix users")
        }
        users.forEach { user ->  UserItem(user = user)}
        }
    }



@Composable
fun SecondTipWrightContent(vm: SecondPageViewModel) {
    val users by vm.users.collectAsState()
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = vm::mixUsers , modifier = Modifier.fillMaxWidth(0.9f)) {
            Text("mix users")
        }
        users.forEach { user ->
            key(user.id) {
                UserItem(user = user)
            }
        }
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