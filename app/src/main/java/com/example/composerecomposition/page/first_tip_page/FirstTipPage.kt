package com.example.composerecomposition.page.first_tip_page

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.composerecomposition.ui_component.AppBar
import com.example.composerecomposition.ui_component.BasePage
import com.example.composerecomposition.ui_component.InfoDialog
import com.example.composerecomposition.constant.TipInfo

@Composable
fun FirstTipPage(vm: FirstPageViewModel = hiltViewModel()) {
    InfoDialog(title = "First tip information", info = TipInfo.FIRST_PAGE_INFO)
    Scaffold(topBar = {
        AppBar("First Tip")
    }) {
        BasePage(
            wrongTabContent = { FirstTipWrongContent(vm) },
            wrightTabContent = { FirstTipWrightContent(vm) }
        )
    }
}


@Composable
fun FirstTipWrongContent(vm: FirstPageViewModel) {
    val text by vm.text.collectAsState(initial = "")

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
    Text(text = text, modifier = Modifier.padding(4.dp) )
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
            CustomButton(text = "Generate Double", onClick = { vm.generateDouble() })
            CustomButton(text = "Generate Int", onClick = { vm.generateInt() })
        }
    }
}


@Composable
fun FirstTipWrightContent(vm: FirstPageViewModel) {
    val text by vm.text.collectAsState(initial = "")
    val generateDouble = remember<()-> Unit>{ { vm.generateDouble() } }
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = text, modifier = Modifier.padding(4.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
            CustomButton(text = "Generate Double", onClick = generateDouble)
            CustomButton(text = "Generate Int", onClick = vm::generateInt)
        }
    }
}


@Composable
fun CustomButton(text: String, onClick:()-> Unit) {
    Button(onClick = { onClick()} ,
        modifier = Modifier.padding(4.dp)
        ) {
        Text(text = text, modifier = Modifier.padding(4.dp))
    }
}