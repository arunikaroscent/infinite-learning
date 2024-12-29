package com.example.myapplication.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapplication.data.StudioGhibliMovies
import com.example.myapplication.model.Ghibli

@Composable
fun DetailMovieScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    movieId: Int?
) {
    val newMovieList = StudioGhibliMovies.ghiblis.find { it.id == movieId }
    Column(modifier = Modifier) {
        DetailMovieContent(ghibli = newMovieList)
    }
}

@Composable
private fun DetailMovieContent(
    ghibli: Ghibli?,
    modifier: Modifier = Modifier
) {
    if (ghibli != null) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.White)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
                Image(
                    painter = painterResource(id = ghibli.background),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                Row (modifier = Modifier.padding(16.dp)){
                    Image(
                        painterResource(ghibli.photo),
                        contentDescription = "",
                        contentScale = ContentScale.FillHeight,
                        modifier = Modifier.height(150.dp)
                    )

                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            text = ghibli.name,
                            style = MaterialTheme.typography.headlineMedium,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = ghibli.year,
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color.Gray
                        )
                    }
                }


                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = ghibli.description,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DetailMentorContentPreview() {
    DetailMovieContent(ghibli = StudioGhibliMovies.ghiblis[0])
}