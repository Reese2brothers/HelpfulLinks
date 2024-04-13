package com.komparo.helpfullinks.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.overscroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.komparo.helpfullinks.R

@SuppressLint("ResourceAsColor")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResourcesScreen(navController: NavController, texts: String,
                    screenTexts: MutableState<Map<String, String>>, imageId : MutableState<Map<Int, Int>>){
    val texted = rememberSaveable { mutableStateOf(screenTexts.value[texts] ?: "") }
    val selectedImage = rememberSaveable { mutableStateOf(imageId.value[texts.toInt()]) }
    val choiseImage = rememberSaveable { mutableStateOf(R.drawable.baseline_image_24) }
    Box (modifier = Modifier
        .fillMaxSize()
        .background(
            brush = Brush.verticalGradient(
                colors = listOf(
                    colorResource(id = R.color.darkblue),
                    colorResource(id = R.color.lightblue)
                )
            )
        )
        .verticalScroll(rememberScrollState()),
        contentAlignment = Alignment.Center){
        Column {
            Row(modifier = Modifier.align(alignment = Alignment.CenterHorizontally)) {
                Card( modifier = Modifier
                    .padding(4.dp)
                    .size(60.dp)
                    .background(Color.Transparent)
                    .clickable {
                        selectedImage.value = R.drawable.baseline_fastfood_24
                        choiseImage.value = R.drawable.baseline_fastfood_24
                    },
                    shape = RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp, bottomEnd = 0.dp, bottomStart = 0.dp),
                   colors = CardDefaults.cardColors(colorResource(id = R.color.darkblue))
                ) {
                        Image(painter = painterResource(id = R.drawable.baseline_fastfood_24),
                            contentDescription = null, modifier = Modifier
                                .size(60.dp)
                                .padding(4.dp)
                                .background(colorResource(id = R.color.milk)))
                }
                Card( modifier = Modifier
                    .padding(4.dp)
                    .size(60.dp)
                    .background(Color.Transparent)
                    .clickable {
                        selectedImage.value = R.drawable.baseline_sports_gymnastics_24
                        choiseImage.value = R.drawable.baseline_sports_gymnastics_24
                    },
                    shape = RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp, bottomEnd = 0.dp, bottomStart = 0.dp),
                    colors = CardDefaults.cardColors(colorResource(id = R.color.darkblue))) {
                    Image(painter = painterResource(id = R.drawable.baseline_sports_gymnastics_24),
                        contentDescription = null, modifier = Modifier
                            .size(60.dp)
                            .padding(4.dp)
                            .background(colorResource(id = R.color.milk)))
                }
                Card( modifier = Modifier
                    .padding(4.dp)
                    .size(60.dp)
                    .background(Color.Transparent)
                    .clickable {
                        selectedImage.value = R.drawable.baseline_audiotrack_24
                        choiseImage.value = R.drawable.baseline_audiotrack_24
                    },
                    shape = RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp, bottomEnd = 0.dp, bottomStart = 0.dp),
                    colors = CardDefaults.cardColors(colorResource(id = R.color.darkblue))) {
                    Image(painter = painterResource(id = R.drawable.baseline_audiotrack_24),
                        contentDescription = null, modifier = Modifier
                            .size(60.dp)
                            .padding(4.dp)
                            .background(colorResource(id = R.color.milk)))
                }
                Card( modifier = Modifier
                    .padding(4.dp)
                    .size(60.dp)
                    .background(Color.Transparent)
                    .clickable {
                        selectedImage.value = R.drawable.baseline_assignment_late_24
                        choiseImage.value = R.drawable.baseline_assignment_late_24
                    },
                    shape = RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp, bottomEnd = 0.dp, bottomStart = 0.dp),
                    colors = CardDefaults.cardColors(colorResource(id = R.color.darkblue))) {
                    Image(painter = painterResource(id = R.drawable.baseline_assignment_late_24),
                        contentDescription = null, modifier = Modifier
                            .size(60.dp)
                            .padding(4.dp)
                            .background(colorResource(id = R.color.milk)))
                }
                Card( modifier = Modifier
                    .padding(4.dp)
                    .size(60.dp)
                    .background(Color.Transparent)
                    .clickable {
                        selectedImage.value = R.drawable.baseline_beach_access_24
                        choiseImage.value = R.drawable.baseline_beach_access_24
                    },
                    shape = RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp, bottomEnd = 0.dp, bottomStart = 0.dp),
                    colors = CardDefaults.cardColors(colorResource(id = R.color.darkblue))) {
                    Image(painter = painterResource(id = R.drawable.baseline_beach_access_24),
                        contentDescription = null, modifier = Modifier
                            .size(60.dp)
                            .padding(4.dp)
                            .background(colorResource(id = R.color.milk)))
                }
            }
            Row(modifier = Modifier.align(alignment = Alignment.CenterHorizontally)) {
                Card( modifier = Modifier
                    .padding(4.dp)
                    .size(60.dp)
                    .background(Color.Transparent)
                    .clickable {
                        selectedImage.value = R.drawable.baseline_cake_24
                        choiseImage.value = R.drawable.baseline_cake_24
                    },
                    shape = RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp, bottomEnd = 0.dp, bottomStart = 0.dp),
                    colors = CardDefaults.cardColors(colorResource(id = R.color.darkblue))
                ) {
                    Image(painter = painterResource(id = R.drawable.baseline_cake_24),
                        contentDescription = null, modifier = Modifier
                            .size(60.dp)
                            .padding(4.dp)
                            .background(colorResource(id = R.color.milk)))
                }
                Card( modifier = Modifier
                    .padding(4.dp)
                    .size(60.dp)
                    .background(Color.Transparent)
                    .clickable {
                        selectedImage.value = R.drawable.baseline_cloud_24
                        choiseImage.value = R.drawable.baseline_cloud_24
                    },
                    shape = RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp, bottomEnd = 0.dp, bottomStart = 0.dp),
                    colors = CardDefaults.cardColors(colorResource(id = R.color.darkblue))) {
                    Image(painter = painterResource(id = R.drawable.baseline_cloud_24),
                        contentDescription = null, modifier = Modifier
                            .size(60.dp)
                            .padding(4.dp)
                            .background(colorResource(id = R.color.milk)))
                }
                Card( modifier = Modifier
                    .padding(4.dp)
                    .size(60.dp)
                    .background(Color.Transparent)
                    .clickable {
                        selectedImage.value = R.drawable.baseline_compost_24
                        choiseImage.value = R.drawable.baseline_compost_24
                    },
                    shape = RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp, bottomEnd = 0.dp, bottomStart = 0.dp),
                    colors = CardDefaults.cardColors(colorResource(id = R.color.darkblue))) {
                    Image(painter = painterResource(id = R.drawable.baseline_compost_24),
                        contentDescription = null, modifier = Modifier
                            .size(60.dp)
                            .padding(4.dp)
                            .background(colorResource(id = R.color.milk)))
                }
                Card( modifier = Modifier
                    .padding(4.dp)
                    .size(60.dp)
                    .background(Color.Transparent)
                    .clickable {
                        selectedImage.value = R.drawable.baseline_desktop_windows_24
                        choiseImage.value = R.drawable.baseline_desktop_windows_24
                    },
                    shape = RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp, bottomEnd = 0.dp, bottomStart = 0.dp),
                    colors = CardDefaults.cardColors(colorResource(id = R.color.darkblue))) {
                    Image(painter = painterResource(id = R.drawable.baseline_desktop_windows_24),
                        contentDescription = null, modifier = Modifier
                            .size(60.dp)
                            .padding(4.dp)
                            .background(colorResource(id = R.color.milk)))
                }
                Card( modifier = Modifier
                    .padding(4.dp)
                    .size(60.dp)
                    .background(Color.Transparent)
                    .clickable {
                        selectedImage.value = R.drawable.baseline_dining_24
                        choiseImage.value = R.drawable.baseline_dining_24
                    },
                    shape = RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp, bottomEnd = 0.dp, bottomStart = 0.dp),
                    colors = CardDefaults.cardColors(colorResource(id = R.color.darkblue))) {
                    Image(painter = painterResource(id = R.drawable.baseline_dining_24),
                        contentDescription = null, modifier = Modifier
                            .size(60.dp)
                            .padding(4.dp)
                            .background(colorResource(id = R.color.milk)))
                }
            }
            Row(modifier = Modifier.align(alignment = Alignment.CenterHorizontally)) {
                Card( modifier = Modifier
                    .padding(4.dp)
                    .size(60.dp)
                    .background(Color.Transparent)
                    .clickable {
                        selectedImage.value = R.drawable.baseline_directions_run_24
                        choiseImage.value = R.drawable.baseline_directions_run_24
                    },
                    shape = RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp, bottomEnd = 0.dp, bottomStart = 0.dp),
                    colors = CardDefaults.cardColors(colorResource(id = R.color.darkblue))
                ) {
                    Image(painter = painterResource(id = R.drawable.baseline_directions_run_24),
                        contentDescription = null, modifier = Modifier
                            .size(60.dp)
                            .padding(4.dp)
                            .background(colorResource(id = R.color.milk)))
                }
                Card( modifier = Modifier
                    .padding(4.dp)
                    .size(60.dp)
                    .background(Color.Transparent)
                    .clickable {
                        selectedImage.value = R.drawable.baseline_duo_24
                        choiseImage.value = R.drawable.baseline_duo_24
                    },
                    shape = RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp, bottomEnd = 0.dp, bottomStart = 0.dp),
                    colors = CardDefaults.cardColors(colorResource(id = R.color.darkblue))) {
                    Image(painter = painterResource(id = R.drawable.baseline_duo_24),
                        contentDescription = null, modifier = Modifier
                            .size(60.dp)
                            .padding(4.dp)
                            .background(colorResource(id = R.color.milk)))
                }
                Card( modifier = Modifier
                    .padding(4.dp)
                    .size(60.dp)
                    .background(Color.Transparent)
                    .clickable {
                        selectedImage.value = R.drawable.baseline_emoji_emotions_24
                        choiseImage.value = R.drawable.baseline_emoji_emotions_24
                    },
                    shape = RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp, bottomEnd = 0.dp, bottomStart = 0.dp),
                    colors = CardDefaults.cardColors(colorResource(id = R.color.darkblue))) {
                    Image(painter = painterResource(id = R.drawable.baseline_emoji_emotions_24),
                        contentDescription = null, modifier = Modifier
                            .size(60.dp)
                            .padding(4.dp)
                            .background(colorResource(id = R.color.milk)))
                }
                Card( modifier = Modifier
                    .padding(4.dp)
                    .size(60.dp)
                    .background(Color.Transparent)
                    .clickable {
                        selectedImage.value = R.drawable.baseline_fitness_center_24
                        choiseImage.value = R.drawable.baseline_fitness_center_24
                    },
                    shape = RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp, bottomEnd = 0.dp, bottomStart = 0.dp),
                    colors = CardDefaults.cardColors(colorResource(id = R.color.darkblue))) {
                    Image(painter = painterResource(id = R.drawable.baseline_fitness_center_24),
                        contentDescription = null, modifier = Modifier
                            .size(60.dp)
                            .padding(4.dp)
                            .background(colorResource(id = R.color.milk)))
                }
                Card( modifier = Modifier
                    .padding(4.dp)
                    .size(60.dp)
                    .background(Color.Transparent)
                    .clickable {
                        selectedImage.value = R.drawable.baseline_grass_24
                        choiseImage.value = R.drawable.baseline_grass_24
                    },
                    shape = RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp, bottomEnd = 0.dp, bottomStart = 0.dp),
                    colors = CardDefaults.cardColors(colorResource(id = R.color.darkblue))) {
                    Image(painter = painterResource(id = R.drawable.baseline_grass_24),
                        contentDescription = null, modifier = Modifier
                            .size(60.dp)
                            .padding(4.dp)
                            .background(colorResource(id = R.color.milk)))
                }
            }
            Row(modifier = Modifier.align(alignment = Alignment.CenterHorizontally)) {
                Card( modifier = Modifier
                    .padding(4.dp)
                    .size(60.dp)
                    .background(Color.Transparent)
                    .clickable {
                        selectedImage.value = R.drawable.baseline_lightbulb_24
                        choiseImage.value = R.drawable.baseline_lightbulb_24
                    },
                    shape = RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp, bottomEnd = 0.dp, bottomStart = 0.dp),
                    colors = CardDefaults.cardColors(colorResource(id = R.color.darkblue))
                ) {
                    Image(painter = painterResource(id = R.drawable.baseline_lightbulb_24),
                        contentDescription = null, modifier = Modifier
                            .size(60.dp)
                            .padding(4.dp)
                            .background(colorResource(id = R.color.milk)))
                }
                Card( modifier = Modifier
                    .padding(4.dp)
                    .size(60.dp)
                    .background(Color.Transparent)
                    .clickable {
                        selectedImage.value = R.drawable.baseline_local_florist_24
                        choiseImage.value = R.drawable.baseline_local_florist_24
                    },
                    shape = RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp, bottomEnd = 0.dp, bottomStart = 0.dp),
                    colors = CardDefaults.cardColors(colorResource(id = R.color.darkblue))) {
                    Image(painter = painterResource(id = R.drawable.baseline_local_florist_24),
                        contentDescription = null, modifier = Modifier
                            .size(60.dp)
                            .padding(4.dp)
                            .background(colorResource(id = R.color.milk)))
                }
                Card( modifier = Modifier
                    .padding(4.dp)
                    .size(60.dp)
                    .background(Color.Transparent)
                    .clickable {
                        selectedImage.value = R.drawable.baseline_local_hospital_24
                        choiseImage.value = R.drawable.baseline_local_hospital_24
                    },
                    shape = RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp, bottomEnd = 0.dp, bottomStart = 0.dp),
                    colors = CardDefaults.cardColors(colorResource(id = R.color.darkblue))) {
                    Image(painter = painterResource(id = R.drawable.baseline_local_hospital_24),
                        contentDescription = null, modifier = Modifier
                            .size(60.dp)
                            .padding(4.dp)
                            .background(colorResource(id = R.color.milk)))
                }
                Card( modifier = Modifier
                    .padding(4.dp)
                    .size(60.dp)
                    .background(Color.Transparent)
                    .clickable {
                        selectedImage.value = R.drawable.baseline_play_circle_24
                        choiseImage.value = R.drawable.baseline_play_circle_24
                    },
                    shape = RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp, bottomEnd = 0.dp, bottomStart = 0.dp),
                    colors = CardDefaults.cardColors(colorResource(id = R.color.darkblue))) {
                    Image(painter = painterResource(id = R.drawable.baseline_play_circle_24),
                        contentDescription = null, modifier = Modifier
                            .size(60.dp)
                            .padding(4.dp)
                            .background(colorResource(id = R.color.milk)))
                }
                Card( modifier = Modifier
                    .padding(4.dp)
                    .size(60.dp)
                    .background(Color.Transparent)
                    .clickable {
                        selectedImage.value = R.drawable.baseline_priority_high_24
                        choiseImage.value = R.drawable.baseline_priority_high_24
                    },
                    shape = RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp, bottomEnd = 0.dp, bottomStart = 0.dp),
                    colors = CardDefaults.cardColors(colorResource(id = R.color.darkblue))) {
                    Image(painter = painterResource(id = R.drawable.baseline_priority_high_24),
                        contentDescription = null, modifier = Modifier
                            .size(60.dp)
                            .padding(4.dp)
                            .background(colorResource(id = R.color.milk)))
                }
            }
            Row(modifier = Modifier.align(alignment = Alignment.CenterHorizontally)) {
                Card( modifier = Modifier
                    .padding(4.dp)
                    .size(60.dp)
                    .background(Color.Transparent)
                    .clickable {
                        selectedImage.value = R.drawable.baseline_restaurant_24
                        choiseImage.value = R.drawable.baseline_restaurant_24
                    },
                    shape = RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp, bottomEnd = 0.dp, bottomStart = 0.dp),
                    colors = CardDefaults.cardColors(colorResource(id = R.color.darkblue))
                ) {
                    Image(painter = painterResource(id = R.drawable.baseline_restaurant_24),
                        contentDescription = null, modifier = Modifier
                            .size(60.dp)
                            .padding(4.dp)
                            .background(colorResource(id = R.color.milk)))
                }
                Card( modifier = Modifier
                    .padding(4.dp)
                    .size(60.dp)
                    .background(Color.Transparent)
                    .clickable {
                        selectedImage.value = R.drawable.baseline_sick_24
                        choiseImage.value = R.drawable.baseline_sick_24
                    },
                    shape = RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp, bottomEnd = 0.dp, bottomStart = 0.dp),
                    colors = CardDefaults.cardColors(colorResource(id = R.color.darkblue))) {
                    Image(painter = painterResource(id = R.drawable.baseline_sick_24),
                        contentDescription = null, modifier = Modifier
                            .size(60.dp)
                            .padding(4.dp)
                            .background(colorResource(id = R.color.milk)))
                }
                Card( modifier = Modifier
                    .padding(4.dp)
                    .size(60.dp)
                    .background(Color.Transparent)
                    .clickable {
                        selectedImage.value = R.drawable.baseline_sports_24
                        choiseImage.value = R.drawable.baseline_sports_24
                    },
                    shape = RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp, bottomEnd = 0.dp, bottomStart = 0.dp),
                    colors = CardDefaults.cardColors(colorResource(id = R.color.darkblue))) {
                    Image(painter = painterResource(id = R.drawable.baseline_sports_24),
                        contentDescription = null, modifier = Modifier
                            .size(60.dp)
                            .padding(4.dp)
                            .background(colorResource(id = R.color.milk)))
                }
                Card( modifier = Modifier
                    .padding(4.dp)
                    .size(60.dp)
                    .background(Color.Transparent)
                    .clickable {
                        selectedImage.value = R.drawable.baseline_yard_24
                        choiseImage.value = R.drawable.baseline_yard_24
                    },
                    shape = RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp, bottomEnd = 0.dp, bottomStart = 0.dp),
                    colors = CardDefaults.cardColors(colorResource(id = R.color.darkblue))) {
                    Image(painter = painterResource(id = R.drawable.baseline_yard_24),
                        contentDescription = null, modifier = Modifier
                            .size(60.dp)
                            .padding(4.dp)
                            .background(colorResource(id = R.color.milk)))
                }
                Card( modifier = Modifier
                    .padding(4.dp)
                    .size(60.dp)
                    .background(Color.Transparent)
                    .clickable {
                        selectedImage.value = R.drawable.baseline_woman_24
                        choiseImage.value = R.drawable.baseline_woman_24
                    },
                    shape = RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp, bottomEnd = 0.dp, bottomStart = 0.dp),
                    colors = CardDefaults.cardColors(colorResource(id = R.color.darkblue))) {
                    Image(painter = painterResource(id = R.drawable.baseline_woman_24),
                        contentDescription = null, modifier = Modifier
                            .size(60.dp)
                            .padding(4.dp)
                            .background(colorResource(id = R.color.milk)))
                }
            }
            Divider(color = colorResource(id = R.color.milk), thickness = 2.dp, modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp))
            TextField(value = texted.value, onValueChange = { newValue -> texted.value = newValue },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp, end = 8.dp, top = 8.dp),
                textStyle = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Monospace
                ),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = colorResource(id = R.color.milk),
                    cursorColor = colorResource(id = R.color.darkblue),
                    unfocusedIndicatorColor = colorResource(id = R.color.darkblue),
                    textColor = colorResource(id = R.color.darkblue)
                )
            )
            Card( modifier = Modifier
                .padding(top = 16.dp)
                .size(100.dp)
                .background(Color.Transparent)
                .align(Alignment.CenterHorizontally),
                shape = RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp, bottomEnd = 0.dp, bottomStart = 0.dp),
                colors = CardDefaults.cardColors(colorResource(id = R.color.darkblue))
            ) {
                Image(painter = painterResource(id = choiseImage.value),
                    contentDescription = null, modifier = Modifier
                        .size(100.dp)
                        .padding(4.dp)
                        .background(colorResource(id = R.color.milk)))
            }
            Button(modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(start = 8.dp, end = 8.dp, top = 16.dp, bottom = 16.dp),
                colors = ButtonDefaults.buttonColors(colorResource(id = R.color.darkblue)),
                shape = CutCornerShape(20.dp),
                onClick = {
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
                Text("Сохранить",  color = colorResource(id = R.color.milk),
                    fontSize = 24.sp,  fontFamily = FontFamily.Monospace)
            }
        }
    }
}