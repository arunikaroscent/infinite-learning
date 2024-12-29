package com.example.myapplication.navigation

sealed class Screen (val route: String){
    data object Home : Screen("home")
    data object Detail : Screen("detail")
    data object Favorite: Screen("favorite")
    data object About: Screen("about")
}