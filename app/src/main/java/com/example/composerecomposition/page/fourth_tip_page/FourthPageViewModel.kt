package com.example.composerecomposition.page.fourth_tip_page

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.example.composerecomposition.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class FourthPageViewModel @Inject constructor(): ViewModel() {

    private val list: List<User> = listOf(
        User(0, "John"),
        User(1, "Alice"),
        User(2, "Jack"),
        User(3, "Helen"),
        User(4, "David")
    )

    private val colorsList = listOf(Color.Blue, Color.Cyan, Color.DarkGray, Color.Gray, Color.Magenta, Color.Red, Color.Yellow)

    private val _users = MutableStateFlow<List<User>>(list)

    val users: StateFlow<List<User>> = _users

    private val _color = MutableStateFlow(Color.White)

    val color: StateFlow<Color> = _color

    fun changeColor(){
        _color.value = colorsList.random()
    }
}

@HiltViewModel
class FourthPageViewModel2 @Inject constructor(): ViewModel() {

    private val list: PersistentList<User> = persistentListOf(
        User(0, "John"),
        User(1, "Alice"),
        User(2, "Jack"),
        User(3, "Helen"),
        User(4, "David")
    )

    private val colorsList = listOf(Color.Blue, Color.Cyan, Color.DarkGray, Color.Gray, Color.Magenta, Color.Red, Color.Yellow)

    private val _users = MutableStateFlow<ImmutableList<User>>(list)

    val users: StateFlow<ImmutableList<User>> = _users

    private val _color = MutableStateFlow(Color.White)

    val color: StateFlow<Color> = _color

    fun changeColor(){
        _color.value = colorsList.random()
    }
}

