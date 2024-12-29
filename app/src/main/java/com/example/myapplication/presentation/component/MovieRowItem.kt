package com.example.myapplication.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.data.StudioGhibliMovies
import com.example.myapplication.model.Ghibli

@Composable
fun MovieRowItem(
    ghibli: Ghibli,
    modifier: Modifier = Modifier,
    onItemClicked: (Int) -> Unit
) {
    Box(
        modifier = Modifier
            .aspectRatio(1.8f)
            .clip(RoundedCornerShape(12.dp))
            .clickable { onItemClicked(ghibli.id) }
            .height(200.dp)
    ) {
        Image(
            painter = painterResource(id = ghibli.background),
            contentDescription = "Foto background",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .drawWithCache {
                    onDrawWithContent {
                        drawContent()
                        drawRect(
                            Brush.verticalGradient(
                                0.5f to Color.Black.copy(alpha = 0F),
                                0.9F to Color.Black
                            )
                        )
                    }
                }
        )

        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Bottom
        ) {
            Text(
                text = ghibli.name,
                style = MaterialTheme.typography.titleLarge,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = ghibli.year,
                style = MaterialTheme.typography.labelMedium,
                color = Color.White
            )
        }
    }
}

@Preview("Tes")
@Composable
fun MovieRowPreview() {
    MovieRowItem(
        ghibli = StudioGhibliMovies.ghiblis[0],
        onItemClicked = { movieId ->
            println("Id : $movieId")
        }
    )
}