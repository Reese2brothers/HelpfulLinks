package com.komparo.helpfullinks.screens

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
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
import androidx.compose.ui.platform.LocalContext
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
fun ResourcesScreen(context : Context, navController: NavController, texts: String,
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
                        selectedImage.value = R.drawable.vopros
                        choiseImage.value = R.drawable.vopros
                    },
                    shape = RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp, bottomEnd = 0.dp, bottomStart = 0.dp),
                   colors = CardDefaults.cardColors(colorResource(id = R.color.darkblue))
                ) {
                        Image(painter = painterResource(id = R.drawable.vopros),
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
                        selectedImage.value = R.drawable.videos
                        choiseImage.value = R.drawable.videos
                    },
                    shape = RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp, bottomEnd = 0.dp, bottomStart = 0.dp),
                    colors = CardDefaults.cardColors(colorResource(id = R.color.darkblue))) {
                    Image(painter = painterResource(id = R.drawable.videos),
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
                        selectedImage.value = R.drawable.trava
                        choiseImage.value = R.drawable.trava
                    },
                    shape = RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp, bottomEnd = 0.dp, bottomStart = 0.dp),
                    colors = CardDefaults.cardColors(colorResource(id = R.color.darkblue))) {
                    Image(painter = painterResource(id = R.drawable.trava),
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
                        selectedImage.value = R.drawable.stupathree
                        choiseImage.value = R.drawable.stupathree
                    },
                    shape = RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp, bottomEnd = 0.dp, bottomStart = 0.dp),
                    colors = CardDefaults.cardColors(colorResource(id = R.color.darkblue))) {
                    Image(painter = painterResource(id = R.drawable.stupathree),
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
                        selectedImage.value = R.drawable.stupatwo
                        choiseImage.value = R.drawable.stupatwo
                    },
                    shape = RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp, bottomEnd = 0.dp, bottomStart = 0.dp),
                    colors = CardDefaults.cardColors(colorResource(id = R.color.darkblue))) {
                    Image(painter = painterResource(id = R.drawable.stupatwo),
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
                        selectedImage.value = R.drawable.stupaone
                        choiseImage.value = R.drawable.stupaone
                    },
                    shape = RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp, bottomEnd = 0.dp, bottomStart = 0.dp),
                    colors = CardDefaults.cardColors(colorResource(id = R.color.darkblue))
                ) {
                    Image(painter = painterResource(id = R.drawable.stupaone),
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
                        selectedImage.value = R.drawable.sewingmashine
                        choiseImage.value = R.drawable.sewingmashine
                    },
                    shape = RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp, bottomEnd = 0.dp, bottomStart = 0.dp),
                    colors = CardDefaults.cardColors(colorResource(id = R.color.darkblue))) {
                    Image(painter = painterResource(id = R.drawable.sewingmashine),
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
                        selectedImage.value = R.drawable.run
                        choiseImage.value = R.drawable.run
                    },
                    shape = RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp, bottomEnd = 0.dp, bottomStart = 0.dp),
                    colors = CardDefaults.cardColors(colorResource(id = R.color.darkblue))) {
                    Image(painter = painterResource(id = R.drawable.run),
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
                        selectedImage.value = R.drawable.pregnant
                        choiseImage.value = R.drawable.pregnant
                    },
                    shape = RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp, bottomEnd = 0.dp, bottomStart = 0.dp),
                    colors = CardDefaults.cardColors(colorResource(id = R.color.darkblue))) {
                    Image(painter = painterResource(id = R.drawable.pregnant),
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
                        selectedImage.value = R.drawable.plate
                        choiseImage.value = R.drawable.plate
                    },
                    shape = RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp, bottomEnd = 0.dp, bottomStart = 0.dp),
                    colors = CardDefaults.cardColors(colorResource(id = R.color.darkblue))) {
                    Image(painter = painterResource(id = R.drawable.plate),
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
                        selectedImage.value = R.drawable.nofood
                        choiseImage.value = R.drawable.nofood
                    },
                    shape = RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp, bottomEnd = 0.dp, bottomStart = 0.dp),
                    colors = CardDefaults.cardColors(colorResource(id = R.color.darkblue))
                ) {
                    Image(painter = painterResource(id = R.drawable.nofood),
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
                        selectedImage.value = R.drawable.nitki
                        choiseImage.value = R.drawable.nitki
                    },
                    shape = RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp, bottomEnd = 0.dp, bottomStart = 0.dp),
                    colors = CardDefaults.cardColors(colorResource(id = R.color.darkblue))) {
                    Image(painter = painterResource(id = R.drawable.nitki),
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
                        selectedImage.value = R.drawable.hleb
                        choiseImage.value = R.drawable.hleb
                    },
                    shape = RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp, bottomEnd = 0.dp, bottomStart = 0.dp),
                    colors = CardDefaults.cardColors(colorResource(id = R.color.darkblue))) {
                    Image(painter = painterResource(id = R.drawable.hleb),
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
                        selectedImage.value = R.drawable.hearth
                        choiseImage.value = R.drawable.hearth
                    },
                    shape = RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp, bottomEnd = 0.dp, bottomStart = 0.dp),
                    colors = CardDefaults.cardColors(colorResource(id = R.color.darkblue))) {
                    Image(painter = painterResource(id = R.drawable.hearth),
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
                        selectedImage.value = R.drawable.gymnast
                        choiseImage.value = R.drawable.gymnast
                    },
                    shape = RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp, bottomEnd = 0.dp, bottomStart = 0.dp),
                    colors = CardDefaults.cardColors(colorResource(id = R.color.darkblue))) {
                    Image(painter = painterResource(id = R.drawable.gymnast),
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
                        selectedImage.value = R.drawable.griadka
                        choiseImage.value = R.drawable.griadka
                    },
                    shape = RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp, bottomEnd = 0.dp, bottomStart = 0.dp),
                    colors = CardDefaults.cardColors(colorResource(id = R.color.darkblue))
                ) {
                    Image(painter = painterResource(id = R.drawable.griadka),
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
                        selectedImage.value = R.drawable.gnom
                        choiseImage.value = R.drawable.gnom
                    },
                    shape = RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp, bottomEnd = 0.dp, bottomStart = 0.dp),
                    colors = CardDefaults.cardColors(colorResource(id = R.color.darkblue))) {
                    Image(painter = painterResource(id = R.drawable.gnom),
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
                        selectedImage.value = R.drawable.giria
                        choiseImage.value = R.drawable.giria
                    },
                    shape = RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp, bottomEnd = 0.dp, bottomStart = 0.dp),
                    colors = CardDefaults.cardColors(colorResource(id = R.color.darkblue))) {
                    Image(painter = painterResource(id = R.drawable.giria),
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
                        selectedImage.value = R.drawable.fitness
                        choiseImage.value = R.drawable.fitness
                    },
                    shape = RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp, bottomEnd = 0.dp, bottomStart = 0.dp),
                    colors = CardDefaults.cardColors(colorResource(id = R.color.darkblue))) {
                    Image(painter = painterResource(id = R.drawable.fitness),
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
                        selectedImage.value = R.drawable.face
                        choiseImage.value = R.drawable.face
                    },
                    shape = RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp, bottomEnd = 0.dp, bottomStart = 0.dp),
                    colors = CardDefaults.cardColors(colorResource(id = R.color.darkblue))) {
                    Image(painter = painterResource(id = R.drawable.face),
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
                        selectedImage.value = R.drawable.dress
                        choiseImage.value = R.drawable.dress
                    },
                    shape = RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp, bottomEnd = 0.dp, bottomStart = 0.dp),
                    colors = CardDefaults.cardColors(colorResource(id = R.color.darkblue))
                ) {
                    Image(painter = painterResource(id = R.drawable.dress),
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
                        selectedImage.value = R.drawable.cloth
                        choiseImage.value = R.drawable.cloth
                    },
                    shape = RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp, bottomEnd = 0.dp, bottomStart = 0.dp),
                    colors = CardDefaults.cardColors(colorResource(id = R.color.darkblue))) {
                    Image(painter = painterResource(id = R.drawable.cloth),
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
                        selectedImage.value = R.drawable.cepi
                        choiseImage.value = R.drawable.cepi
                    },
                    shape = RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp, bottomEnd = 0.dp, bottomStart = 0.dp),
                    colors = CardDefaults.cardColors(colorResource(id = R.color.darkblue))) {
                    Image(painter = painterResource(id = R.drawable.cepi),
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
                        selectedImage.value = R.drawable.cake
                        choiseImage.value = R.drawable.cake
                    },
                    shape = RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp, bottomEnd = 0.dp, bottomStart = 0.dp),
                    colors = CardDefaults.cardColors(colorResource(id = R.color.darkblue))) {
                    Image(painter = painterResource(id = R.drawable.cake),
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
                        selectedImage.value = R.drawable.clothes
                        choiseImage.value = R.drawable.clothes
                    },
                    shape = RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp, bottomEnd = 0.dp, bottomStart = 0.dp),
                    colors = CardDefaults.cardColors(colorResource(id = R.color.darkblue))) {
                    Image(painter = painterResource(id = R.drawable.clothes),
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
                    if(!texted.value.isNullOrEmpty()){
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
                    } else {
                        Toast.makeText(context, "Введите заголовок!", Toast.LENGTH_SHORT).show()
                    }
            }) {
                Text("Сохранить",  color = colorResource(id = R.color.milk),
                    fontSize = 24.sp,  fontFamily = FontFamily.Monospace)
            }
        }
    }
}