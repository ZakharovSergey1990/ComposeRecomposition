package com.example.composerecomposition.ui_component

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Snackbar
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun BottomSnackbar(text: String) {
    var showSnackbar by remember { mutableStateOf(true) }
    if(!showSnackbar) return
    Snackbar(
        modifier = Modifier.padding(4.dp),
        action = {
            TextButton(onClick = {
                showSnackbar = false
            }) {
                Text(text = "Remove", color = MaterialTheme.colorScheme.onPrimary)
            }
        }
    ) {
        Text(text = text)
    }
}