package com.example.myapplication.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.myapplication.data.StudioGhibliMovies
import com.example.myapplication.model.Ghibli
import com.example.myapplication.navigation.Screen
import com.example.myapplication.presentation.component.MovieGridGradient

@Composable
fun FavoriteScreen(
    navController: NavController,
    ghiblis: List<Ghibli> = StudioGhibliMovies.ghiblis,
    modifier: Modifier = Modifier,
) {
    Column(Modifier.fillMaxSize()) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
            content = {
                itemsIndexed(ghiblis) { index, item ->
                    MovieGridGradient(ghiblis = item, Modifier.fillMaxSize()) { movieId ->
                        navController.navigate(Screen.Detail.route + "/$movieId")
                    }
                }
            }
        )
    }
}

