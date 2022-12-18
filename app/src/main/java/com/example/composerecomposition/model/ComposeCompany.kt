package com.example.composerecomposition.model

import com.example.anothermodule.Company

data class ComposeCompany(
    val id: Int,
    val name: String
)

fun Company.convertToComposeClass():ComposeCompany{
    return ComposeCompany(this.id, this.name)
}
