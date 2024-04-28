package com.komparo.helpfullinks.screens

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.komparo.helpfullinks.R
import com.komparo.helpfullinks.data.AppDatabase
import com.komparo.helpfullinks.data.model.Eight
import com.komparo.helpfullinks.data.model.Eleven
import com.komparo.helpfullinks.data.model.Fifteen
import com.komparo.helpfullinks.data.model.Five
import com.komparo.helpfullinks.data.model.Four
import com.komparo.helpfullinks.data.model.Fourteen
import com.komparo.helpfullinks.data.model.Nine
import com.komparo.helpfullinks.data.model.One
import com.komparo.helpfullinks.data.model.Seven
import com.komparo.helpfullinks.data.model.Six
import com.komparo.helpfullinks.data.model.Ten
import com.komparo.helpfullinks.data.model.Thirteen
import com.komparo.helpfullinks.data.model.Three
import com.komparo.helpfullinks.data.model.Twelve
import com.komparo.helpfullinks.data.model.Two
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@SuppressLint("ResourceAsColor")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResourcesScreen(database : AppDatabase, context : Context, navController: NavController, texts: String,
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
                            0 -> ScreenData.OneScreen
                            1 -> ScreenData.TwoScreen
                            2 -> ScreenData.ThreeScreen
                            3 -> ScreenData.FourScreen
                            4 -> ScreenData.FiveScreen
                            5 -> ScreenData.SixScreen
                            6 -> ScreenData.SevenScreen
                            7 -> ScreenData.EightScreen
                            8 -> ScreenData.NineScreen
                            9 -> ScreenData.TenScreen
                            10 -> ScreenData.ElevenScreen
                            11 -> ScreenData.TwelveScreen
                            12 -> ScreenData.ThirteenScreen
                            13 -> ScreenData.FourteenScreen
                            else -> ScreenData.FifteenScreen
                        }
                        when(screenData){
                            is ScreenData.OneScreen -> {
                                    database.oneDao().deleteAll()
                                    database.oneDao().insertOne(One(title = texted.value, image = selectedImage.value.toString()))
                            }
                            is ScreenData.TwoScreen -> {
                                database.twoDao().deleteAll()
                                database.twoDao().insertTwo(Two(title = texted.value, image = selectedImage.value.toString()))
                            }
                            is ScreenData.ThreeScreen -> {
                                database.threeDao().deleteAll()
                                database.threeDao().insertThree(Three(title = texted.value, image = selectedImage.value.toString()))
                            }
                            is ScreenData.FourScreen -> {
                                database.fourDao().deleteAll()
                                database.fourDao().insertFour(Four(title = texted.value, image = selectedImage.value.toString()))
                            }
                            is ScreenData.FiveScreen -> {
                                database.fiveDao().deleteAll()
                                database.fiveDao().insertFive(Five(title = texted.value, image = selectedImage.value.toString()))
                            }
                            is ScreenData.SixScreen -> {
                                database.sixDao().deleteAll()
                                database.sixDao().insertSix(Six(title = texted.value, image = selectedImage.value.toString()))
                            }
                            is ScreenData.SevenScreen -> {
                                database.sevenDao().deleteAll()
                                database.sevenDao().insertSeven(Seven(title = texted.value, image = selectedImage.value.toString()))
                            }
                            is ScreenData.EightScreen -> {
                                database.eightDao().deleteAll()
                                database.eightDao().insertEight(Eight(title = texted.value, image = selectedImage.value.toString()))
                            }
                            is ScreenData.NineScreen -> {
                                database.nineDao().deleteAll()
                                database.nineDao().insertNine(Nine(title = texted.value, image = selectedImage.value.toString()))
                            }
                            is ScreenData.TenScreen -> {
                                database.tenDao().deleteAll()
                                database.tenDao().insertTen(Ten(title = texted.value, image = selectedImage.value.toString()))
                            }
                            is ScreenData.ElevenScreen -> {
                                database.elevenDao().deleteAll()
                                database.elevenDao().insertEleven(Eleven(title = texted.value, image = selectedImage.value.toString()))
                            }
                            is ScreenData.TwelveScreen -> {
                                database.twelveDao().deleteAll()
                                database.twelveDao().insertTwelve(Twelve(title = texted.value, image = selectedImage.value.toString()))
                            }
                            is ScreenData.ThirteenScreen -> {
                                database.thirteenDao().deleteAll()
                                database.thirteenDao().insertThirteen(Thirteen(title = texted.value, image = selectedImage.value.toString()))
                            }
                            is ScreenData.FourteenScreen -> {
                                database.fourteenDao().deleteAll()
                                database.fourteenDao().insertFourteen(Fourteen(title = texted.value, image = selectedImage.value.toString()))
                            }
                            is ScreenData.FifteenScreen -> {
                                database.fifteenDao().deleteAll()
                                database.fifteenDao().insertFifteen(Fifteen(title = texted.value, image = selectedImage.value.toString()))
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