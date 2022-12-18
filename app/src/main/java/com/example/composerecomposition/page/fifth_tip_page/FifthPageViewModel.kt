package com.example.composerecomposition.page.fifth_tip_page

import androidx.lifecycle.ViewModel
import com.example.composerecomposition.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject


@HiltViewModel
class FifthPageViewModel @Inject constructor(): ViewModel() {

    private val _users: MutableStateFlow<List<User>> = MutableStateFlow(emptyList())
    val users: StateFlow<List<User>> = _users

    init {
        val mutableList = mutableListOf<User>()
        for (i in 1..100){
            mutableList.add(User(i, "User $i"))
        }
        _users.value = mutableList
    }

}