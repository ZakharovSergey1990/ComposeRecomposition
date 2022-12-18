package com.example.composerecomposition.ui_component

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun BasePage(
    wrongTabContent: @Composable () -> Unit,
    wrightTabContent: @Composable () -> Unit
) {
    var selectedTabIndex by remember { mutableStateOf(0) }
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        TabRow(selectedTabIndex = selectedTabIndex) {
            Tab(selected = selectedTabIndex == 0, onClick = { selectedTabIndex = 0 }, modifier = Modifier.padding(4.dp)) {
                Text("wrong", fontSize = MaterialTheme.typography.titleLarge.fontSize)
            }
            Tab(selected = selectedTabIndex == 1, onClick = { selectedTabIndex = 1 }, modifier = Modifier.padding(4.dp)) {
                Text("wright", fontSize = MaterialTheme.typography.titleLarge.fontSize)
            }
        }
        when (selectedTabIndex) {
            0 -> wrongTabContent()
            1 -> wrightTabContent()
        }
    }
}