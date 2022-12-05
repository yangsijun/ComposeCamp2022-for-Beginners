package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ArtSpace()
                }
            }
        }
    }
}

@Composable
fun ArtSpace() {
    var page by remember { mutableStateOf(0) }
    var image = getImage(page)
    var imageDescription = getImageDescription(page)
    var artworkTitle = getArtworkTitle(page)
    var artistName = getArtistName(page)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .shadow(8.dp)
                    .border(BorderStroke(1.dp, MaterialTheme.colors.onSurface))
            ) {
                Image(
                    painter = painterResource(id = image),
                    contentDescription = stringResource(id = imageDescription),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(32.dp),
                )
            }
        }
        Surface(
            modifier = Modifier
                .wrapContentSize(),
            elevation = 8.dp,
            color = MaterialTheme.colors.background,
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.Start,
            ) {
                Text(
                    text = stringResource(id = artworkTitle),
                    fontSize = 24.sp,
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(bottom = 8.dp)
                )
                Text(
                    text = stringResource(id = artistName),
                    fontSize = 12.sp,
                    modifier = Modifier
                        .wrapContentSize()
                )
            }
        }
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(16.dp)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = {
                    page = previousButtonAction(page)
                    image = getImage(page)
                    imageDescription = getImageDescription(page)
                    artworkTitle = getArtworkTitle(page)
                    artistName = getArtistName(page)
                },
                modifier = Modifier
                    .weight(1f)
            ) {
                Text(text = stringResource(id = R.string.previous_button_text))
            }
            Spacer(Modifier.width(16.dp))
            Button(
                onClick = {
                    page = nextButtonAction(page)
                    image = getImage(page)
                    imageDescription = getImageDescription(page)
                    artworkTitle = getArtworkTitle(page)
                    artistName = getArtistName(page)
                },
                modifier = Modifier
                    .weight(1f)
            ) {
                Text(text = stringResource(id = R.string.next_button_text))
            }
        }
    }
}

fun previousButtonAction(page: Int): Int {
    return if (page == 0) {
        2
    } else {
        page - 1
    }
}

fun nextButtonAction(page: Int): Int {
    return if (page == 2) {
        0
    } else {
        page + 1
    }
}

fun getArtistName(page: Int): Int {
    return when (page) {
        0 -> R.string.artist_artwork1
        1 -> R.string.artist_artwork2
        2 -> R.string.artist_artwork3
        else -> R.string.artist_artwork1
    }
}

fun getImage(page: Int): Int {
    return when (page) {
        0 -> R.drawable.artwork_1
        1 -> R.drawable.artwork_2
        2 -> R.drawable.artwork_3
        else -> R.drawable.artwork_1
    }
}

fun getImageDescription(page: Int): Int {
    return when (page) {
        0 -> R.string.image_description_artwork1
        1 -> R.string.image_description_artwork2
        2 -> R.string.image_description_artwork3
        else -> R.string.image_description_artwork1
    }
}

fun getArtworkTitle(page: Int): Int {
    return when (page) {
        0 -> R.string.title_artwork1
        1 -> R.string.title_artwork2
        2 -> R.string.title_artwork3
        else -> R.string.title_artwork1
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtSpaceTheme {
        ArtSpace()
    }
}