package com.example.composerecomposition.ui_component

import android.app.AlertDialog
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*

@Composable
fun InfoDialog(title: String, info: String) {
    var showDialog by remember { mutableStateOf(true) }
    if(!showDialog) return
    AlertDialog(
        onDismissRequest = {},
        title = {
            Text(text = title)
        },
        text = {
            Text(info)
        },
        confirmButton = {
            Button(onClick = {
                showDialog = false
            }){
                Text(text = "Ok")
            }
        }
    )
}