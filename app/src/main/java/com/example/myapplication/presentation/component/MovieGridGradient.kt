package com.example.myapplication.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.data.StudioGhibliMovies
import com.example.myapplication.model.Ghibli

@Composable
fun MovieGridGradient(ghiblis: Ghibli, modifier: Modifier, onItemClicked: (Int) -> Unit ) {
    Box(
        Modifier.aspectRatio(9f / 16f)
            .clickable { onItemClicked(ghiblis.id) }
    ) {
        Image(
            painterResource(ghiblis.photo),
            contentDescription = "",
            contentScale = ContentScale.FillHeight,
            modifier = Modifier.drawWithCache {
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
        Text(
            text = ghiblis.name,
            color = Color.LightGray,
            fontSize = 18.sp,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 36.dp)
        )
    }
}

@Preview("Tes")
@Composable
fun MovieGridPreview() {
    MovieGridGradient(ghiblis = StudioGhibliMovies.ghiblis[0], Modifier.fillMaxSize(), onItemClicked = {
        println("Id: $it")
    })
}