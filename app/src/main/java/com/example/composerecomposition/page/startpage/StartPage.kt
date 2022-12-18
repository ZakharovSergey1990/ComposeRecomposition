package com.example.composerecomposition.page.startpage

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.composerecomposition.constant.NavRoute
import com.example.composerecomposition.ui_component.AppBar
import com.example.composerecomposition.ui_component.InfoDialog
import com.example.composerecomposition.constant.TipInfo

@Composable
fun StartPage(navController: NavHostController) {
Scaffold(
    topBar = {
        AppBar("Start Page")
    }
) {
    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            TextButton(modifier = Modifier.padding(8.dp), onClick = {
                navController.navigate(NavRoute.FIRST_EXAMPLE)
            }) {
                Text("first tip", fontSize = MaterialTheme.typography.titleLarge.fontSize)
            }

            TextButton(modifier = Modifier.padding(8.dp), onClick = {
                navController.navigate(NavRoute.SECOND_EXAMPLE)
            }) {
                Text("second tip", fontSize = MaterialTheme.typography.titleLarge.fontSize)
            }

            TextButton(modifier = Modifier.padding(8.dp), onClick = {
                navController.navigate(NavRoute.THIRD_EXAMPLE)
            }) {
                Text("third tip", fontSize = MaterialTheme.typography.titleLarge.fontSize)
            }

            TextButton(modifier = Modifier.padding(8.dp), onClick = {
                navController.navigate(NavRoute.FOURTH_EXAMPLE)
            }) {
                Text("fourth tip", fontSize = MaterialTheme.typography.titleLarge.fontSize)
            }

            TextButton(modifier = Modifier.padding(8.dp), onClick = {
                navController.navigate(NavRoute.FIFTH_EXAMPLE)
            }) {
                Text("fifth tip", fontSize = MaterialTheme.typography.titleLarge.fontSize)
            }
        }
    }
}
}