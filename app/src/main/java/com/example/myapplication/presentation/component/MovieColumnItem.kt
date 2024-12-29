package com.example.myapplication.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.data.StudioGhibliMovies
import com.example.myapplication.model.Ghibli

@Composable
fun MovieColumnItem(
    ghibli: Ghibli,
    modifier: Modifier = Modifier,
    onItemClicked: (Int) -> Unit = {}
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .clickable {
                onItemClicked(ghibli.id)
            }
    ) {

        Column(
            modifier = Modifier
                .weight(3f)
                .fillMaxHeight()
                .padding(start = 16.dp, top = 16.dp, bottom = 16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = ghibli.name,
                style = MaterialTheme.typography.titleLarge,
                color = Color.Black,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
                )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = ghibli.year, style = MaterialTheme.typography.labelLarge, color = Color.Gray
            )
        }

        Image(
            painter = painterResource(id = ghibli.background),
            contentDescription = "Movie Background",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .weight(2f)
                .fillMaxSize()
        )
    }
}

@Preview
@Composable
fun MovieColumnPreview() {
    MovieColumnItem(
        ghibli = StudioGhibliMovies.ghiblis[0], Modifier.fillMaxSize()
    )
}


