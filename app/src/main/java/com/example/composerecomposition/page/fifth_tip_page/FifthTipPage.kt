package com.example.composerecomposition.page.fifth_tip_page

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.composerecomposition.constant.TipInfo
import com.example.composerecomposition.page.fourth_tip_page.UserItem
import com.example.composerecomposition.ui_component.AppBar
import com.example.composerecomposition.ui_component.BasePage
import com.example.composerecomposition.ui_component.BottomSnackbar
import com.example.composerecomposition.ui_component.InfoDialog
import kotlinx.coroutines.launch

@Composable
fun FifthTipPage(vm: FifthPageViewModel = hiltViewModel()) {
    Scaffold(topBar = {
        AppBar("Fifth Tip")
    },
    bottomBar = {
        InfoDialog(title = "Fifth tip information" , info = TipInfo.FIFTH_PAGE_INFO)
    }) {
        BasePage(
            wrongTabContent = {
                FifthTipWrongContent(vm)
            },
            wrightTabContent = {
                FifthTipWrightContent(vm)
            }
        )
    }
}



@Composable
fun FifthTipWrongContent(vm: FifthPageViewModel) {

    val users by vm.users.collectAsState()

    val scrollState = rememberLazyListState()

    val scope = rememberCoroutineScope()

    val showButton = remember (scrollState.firstVisibleItemIndex) { scrollState.firstVisibleItemIndex != 0}

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter){
        LazyColumn(state = scrollState){
            items(users, key = {it.id}) {
                UserItem(user = it)
            }
        }
        if(showButton) {
            Button(onClick = {
                scope.launch {
                    scrollState.animateScrollToItem(0)
                }
            }) {
                Text(text = "To Start")
            }
        }
    }
}



@Composable
fun FifthTipWrightContent(vm: FifthPageViewModel) {
    val users by vm.users.collectAsState()

    val scrollState = rememberLazyListState()

    val scope = rememberCoroutineScope()

    val showButton by remember { derivedStateOf { scrollState.firstVisibleItemIndex != 0 } }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter){
        LazyColumn(state = scrollState){
            items(users, key = {it.id}) {
                UserItem(user = it)
            }
        }
        if(showButton) {
            Button(onClick = {
                scope.launch {
                    scrollState.animateScrollToItem(0)
                }
            }) {
                Text(text = "To Start")
            }
        }
    }
}



