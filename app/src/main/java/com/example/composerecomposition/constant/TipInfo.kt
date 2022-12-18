package com.example.composerecomposition.constant

object TipInfo {
    const val BASE_INFO = "This application show tips how to improve performance of your UI, and reduce the number of display recompositions. Recomposition is the process of calling your composable functions again when inputs change. Use Layout Inspector to see the difference"
    const val FIRST_PAGE_INFO = "When you use lambda, compiler create anonymous class representing the lambda, this class is not stable for compose, better delegate this function to view model, or put this lambda in remember {} block"
    const val SECOND_PAGE_INFO = "Use key function, when you need to explicitly tell what should be used to compare composable on recomposition."
    const val THIRD_PAGE_INFO = "If you have multi-module project, your data classes from another module are unstable for Jetpack Compose. Use map function to convert your domain layer classes to compose level classes, or use primitive parameters"
    const val FOURTH_PAGE_INFO = "Kotlin collections (Map, List, Set) are unstable, use Kotlin immutable collections types"
    const val FIFTH_PAGE_INFO = "Use derivedStateOf {}, when your state or key is changing more than you want to update your UI"
}