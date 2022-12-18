package com.example.composerecomposition.page.first_tip_page

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class FirstPageViewModel @Inject constructor(): ViewModel() {

    private val _text = MutableStateFlow("")
    val text: StateFlow<String> = _text

    fun generateDouble(){
        _text.value = Random.nextDouble(10.0).toString()
    }

    fun generateInt(){
        _text.value = Random.nextInt(10).toString()
    }

}