package com.example.composerecomposition.page.third_tip_page

import androidx.lifecycle.ViewModel
import com.example.anothermodule.Company
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class ThirdPageViewModel @Inject constructor(): ViewModel() {

    private val list: List<Company> = listOf(
        Company(0, "Google"),
        Company(1, "Apple"),
        Company(2, "Xiaomi"),
        Company(3, "LG"),
        Company(4, "Nokia")
    )

    private val _companies = MutableStateFlow<List<Company>>(list)

    val companies: StateFlow<List<Company>> = _companies

    fun mixCompanies(){
        _companies.value = _companies.value.shuffled()
    }
}