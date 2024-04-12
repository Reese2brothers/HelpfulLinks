package com.komparo.helpfullinks.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.komparo.helpfullinks.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResourcesScreen(navController: NavController, texts: String,
                    screenTexts: MutableState<Map<String, String>>, imageId : MutableState<Map<Int, Int>>){
    val texted = rememberSaveable { mutableStateOf(screenTexts.value[texts] ?: "") }
    val selectedImage = rememberSaveable { mutableStateOf(imageId.value[texts.toInt()]) }
    Box (modifier = Modifier
        .fillMaxSize()
        .background(color = Color.Green), contentAlignment = Alignment.Center){
        Column {
            Image(painter = painterResource(id = R.drawable.baseline_fastfood_24),
                contentDescription = null, modifier = Modifier.size(100.dp).clickable {
                    selectedImage.value = R.drawable.baseline_fastfood_24
                })
            Image(painter = painterResource(id = R.drawable.baseline_sports_gymnastics_24),
                contentDescription = null, modifier = Modifier.size(100.dp).clickable {
                    selectedImage.value = R.drawable.baseline_sports_gymnastics_24
                })
            TextField(value = texted.value, onValueChange = { newValue -> texted.value = newValue })
            Button(onClick = {
                screenTexts.value = screenTexts.value.toMutableMap().apply { this[texts] = texted.value }
                imageId.value = imageId.value.toMutableMap().apply { this[texts.toInt()] = selectedImage.value ?: R.drawable.baseline_image_24 }
                navController.navigate("mainScreen/${texted.value}/${selectedImage.value}")
                val screenData: ScreenData = when (texts.toInt()) {
                    1 -> ScreenData.OneScreen
                    2 -> ScreenData.TwoScreen
                    3 -> ScreenData.ThreeScreen
                    4 -> ScreenData.FourScreen
                    5 -> ScreenData.FiveScreen
                    6 -> ScreenData.SixScreen
                    7 -> ScreenData.SevenScreen
                    8 -> ScreenData.EightScreen
                    9 -> ScreenData.NineScreen
                    10 -> ScreenData.TenScreen
                    11 -> ScreenData.ElevenScreen
                    12 -> ScreenData.TwelveScreen
                    13 -> ScreenData.ThirteenScreen
                    14 -> ScreenData.FourteenScreen
                    else -> ScreenData.FifteenScreen
                }
                when(screenData){
                    is ScreenData.OneScreen -> {

                    }
                    is ScreenData.TwoScreen -> {

                    }
                    is ScreenData.ThreeScreen -> {

                    }
                    is ScreenData.FourScreen -> {

                    }
                    is ScreenData.FiveScreen -> {

                    }
                    is ScreenData.SixScreen -> {

                    }
                    is ScreenData.SevenScreen -> {

                    }
                    is ScreenData.EightScreen -> {

                    }
                    is ScreenData.NineScreen -> {

                    }
                    is ScreenData.TenScreen -> {

                    }
                    is ScreenData.ElevenScreen -> {

                    }
                    is ScreenData.TwelveScreen -> {

                    }
                    is ScreenData.ThirteenScreen -> {

                    }
                    is ScreenData.FourteenScreen -> {

                    }
                    is ScreenData.FifteenScreen -> {

                    }
                }
            }) {
                Text("Сохранить")
            }
        }

    }
}