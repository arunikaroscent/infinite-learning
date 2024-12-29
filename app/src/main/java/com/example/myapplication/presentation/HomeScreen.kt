package com.example.myapplication.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapplication.data.StudioGhibliMovies
import com.example.myapplication.model.Ghibli
import com.example.myapplication.navigation.Screen
import com.example.myapplication.presentation.component.MovieColumnItem
import com.example.myapplication.presentation.component.MovieRowItem

@Composable
fun HomeScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    ghiblis: List<Ghibli> = StudioGhibliMovies.ghiblis
) {

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
    ) {
        item {
            Text(text = "Recommended", style = MaterialTheme.typography.headlineMedium, modifier = Modifier.padding(horizontal = 16.dp))
            LazyRow(
                contentPadding = PaddingValues(16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = modifier
            ) {
                items(ghiblis, key = { it.id }) {
                    MovieRowItem(ghibli = it) { movieId ->
                        navController.navigate(Screen.Detail.route + "/$movieId")
                    }
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Ghibli Movies", style = MaterialTheme.typography.headlineMedium, modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp))
        }
        items(ghiblis, key = { it.id }) {
            MovieColumnItem(
                ghibli = it,
                modifier = Modifier.padding(horizontal = 16.dp),
            ) { movieId ->
                navController.navigate(Screen.Detail.route + "/$movieId")
            }
        }
    }
}