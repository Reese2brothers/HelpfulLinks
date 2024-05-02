package com.komparo.helpfullinks.screens

import android.os.Build
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.ComponentRegistry
import coil.ImageLoader
import coil.compose.rememberImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import com.komparo.helpfullinks.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun SplashScreen(navController: NavController){
    val scope = rememberCoroutineScope()
    Box(modifier = Modifier.fillMaxSize().background( brush = Brush.verticalGradient(
        colors = listOf(
            colorResource(id = R.color.darkblue),
            colorResource(id = R.color.lightblue)
        )
    ))) {
        Column(modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val context = LocalContext.current
            val imageLoader = ImageLoader.Builder(context)
                .components(fun ComponentRegistry.Builder.() {
                    if (Build.VERSION.SDK_INT >= 28) {
                        add(ImageDecoderDecoder.Factory())
                    } else {
                        add(GifDecoder.Factory())
                    }
                })
                .build()
            Text(text = "Полезные ссылки", modifier = Modifier.padding(start = 16.dp, top = 24.dp,
                bottom = 8.dp), fontSize = 34.sp, color = colorResource(
                id = R.color.white),
                fontWeight = FontWeight.Bold)
            Image(painter = rememberImagePainter(
                data = R.drawable.giphyclicks,
                imageLoader = imageLoader,
                builder = {
                    crossfade(true)
                }),
                contentDescription = null)
            Image(painter = rememberImagePainter(
                data = R.drawable.vayrloading,
                imageLoader = imageLoader,
                builder = {
                    crossfade(true)
                }),
                contentDescription = null,
                modifier = Modifier.padding(bottom = 64.dp))
        }
    }
    scope.launch {
        delay(2500)
        navController.navigate("mainScreen")
    }
}