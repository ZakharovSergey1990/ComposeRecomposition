package com.example.composerecomposition.page.second_tip_page

import androidx.lifecycle.ViewModel
import com.example.composerecomposition.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class SecondPageViewModel @Inject constructor(): ViewModel() {

    private val list: List<User> = listOf(
        User(0, "John"),
        User(1, "Alice"),
        User(2, "Jack"),
        User(3, "Helen"),
        User(4, "David")
    )

 //   private var index = list.size

    private val _users = MutableStateFlow<List<User>>(list)

    val users: StateFlow<List<User>> = _users

    fun mixUsers(){
        _users.value = _users.value.shuffled()
    }

//    fun addUser(name: String){
//        index++
//        val newList = mutableListOf<User>()
//        newList.addAll(_users.value)
//        newList.add(User(index, name))
//        _users.value = newList.toImmutableList()
//    }
//
//    fun removeUser(user: User){
//        _users.value = _users.value.filter { it.id != user.id }.toImmutableList()
//    }

}