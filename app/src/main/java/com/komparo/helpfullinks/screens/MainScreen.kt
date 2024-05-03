package com.komparo.helpfullinks.screens

import android.app.Activity
import android.content.Context
import android.view.Window
import android.widget.Toast
import androidx.activity.OnBackPressedDispatcher
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.komparo.helpfullinks.R
import com.komparo.helpfullinks.data.AppDatabase


@Composable
fun NavGraphNavigate(database : AppDatabase, context: Context, navController: NavHostController) {
    val imageId = remember { mutableStateOf(mapOf<Int, Int>()) }
    val screenTexts = remember { mutableStateOf(mapOf<String, String>()) }

    NavHost(navController = navController, startDestination = "SplashScreen"){
        composable("SplashScreen"){
            SplashScreen(navController)
        }
        composable("mainScreen"){
            MainScreen(database, context, navController = navController, screenTexts = screenTexts, imageId = imageId)
        }
        composable("mainScreen/{text}/{image}"){
            MainScreen(database, context, navController, screenTexts, imageId)
        }
        composable("ResoursesScreen/{text}/{image}") {backStackEntry ->
            val text = backStackEntry.arguments?.getString("text") ?: ""
            ResourcesScreen(database, context, navController, text, screenTexts, imageId)
        }
        composable("OneScreen"){
            OneScreen(context, database, navController)
        }
        composable("TwoScreen"){
            TwoScreen(context, database, navController)
        }
        composable("ThreeScreen"){
            ThreeScreen(context, database, navController)
        }
        composable("FourScreen"){
            FourScreen(context, database, navController)
        }
        composable("FiveScreen"){
            FiveScreen(context, database, navController)
        }
        composable("SixScreen"){
            SixScreen(context, database, navController)
        }
        composable("SevenScreen"){
            SevenScreen(context, database, navController)
        }
        composable("EightScreen"){
            EightScreen(context, database, navController)
        }
        composable("NineScreen"){
            NineScreen(context, database, navController)
        }
        composable("TenScreen"){
            TenScreen(context, database, navController)
        }
        composable("ElevenScreen"){
            ElevenScreen(context, database, navController)
        }
        composable("TwelveScreen"){
            TwelveScreen(context, database, navController)
        }
        composable("ThirteenScreen"){
            ThirteenScreen(context, database, navController)
        }
        composable("FourteenScreen"){
            FourteenScreen(context, database, navController)
        }
        composable("FifteenScreen"){
            FifteenScreen(context, database, navController)
        }
    }
}

@Composable
fun MainScreen(database : AppDatabase, context : Context, navController: NavController,
               screenTexts: MutableState<Map<String, String>>, imageId : MutableState<Map<Int, Int>>) {
    val screens = listOf("OneScreen", "TwoScreen", "ThreeScreen", "FourScreen", "FiveScreen",
        "SixScreen", "SevenScreen", "EightScreen", "NineScreen", "TenScreen", "ElevenScreen",
        "TwelveScreen", "ThirteenScreen", "FourteenScreen", "FifteenScreen")
    val scrollState = rememberLazyGridState()
    BackHandler {
        Toast.makeText(context, "Вы вышли из приложения!", Toast.LENGTH_SHORT).show()
        (context as Activity).finishAffinity()
    }

    Box(modifier = Modifier
        .fillMaxSize()
        .background(
            brush = Brush.verticalGradient(
                colors = listOf(
                    colorResource(id = R.color.darkblue),
                    colorResource(id = R.color.lightblue)
                )
            )
        )
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Полезные ссылки",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.white), fontFamily = FontFamily.Monospace,
                modifier = Modifier
                    .padding(start = 16.dp))
            Image(painter = painterResource(id = R.drawable.baseline_exit_to_app_24), contentDescription = null,
                modifier = Modifier
                    .size(50.dp)
                    .padding(end = 16.dp)
                    .clickable {
                        (context as Activity).finishAffinity()
                    })
        }
        LazyVerticalGrid(GridCells.Fixed(2), state = scrollState, modifier = Modifier.padding(top = 64.dp)){
            items(15) { screen ->
            val title = when (screen) {
                0 -> {
                    if(database.oneDao().getTitle()?.title != null){
                        database.oneDao().getTitle()?.title.toString()
                    } else{
                        "напишите название..."
                    }
                }
                1 -> {
                    if(database.twoDao().getTitle()?.title != null){
                        database.twoDao().getTitle()?.title.toString()
                    } else{
                        "напишите название..."
                    }
                }
                2 -> {
                    if(database.threeDao().getTitle()?.title != null){
                        database.threeDao().getTitle()?.title.toString()
                    } else{
                        "напишите название..."
                    }
                }
                3 -> {
                    if(database.fourDao().getTitle()?.title != null){
                        database.fourDao().getTitle()?.title.toString()
                    } else{
                        "напишите название..."
                    }
                }
                4 -> {
                    if(database.fiveDao().getTitle()?.title != null){
                        database.fiveDao().getTitle()?.title.toString()
                    } else{
                        "напишите название..."
                    }
                }
                5 -> {
                    if(database.sixDao().getTitle()?.title != null){
                        database.sixDao().getTitle()?.title.toString()
                    } else{
                        "напишите название..."
                    }
                }
                6 -> {
                    if(database.sevenDao().getTitle()?.title != null){
                        database.sevenDao().getTitle()?.title.toString()
                    } else{
                        "напишите название..."
                    }
                }
                7 -> {
                    if(database.eightDao().getTitle()?.title != null){
                        database.eightDao().getTitle()?.title.toString()
                    } else{
                        "напишите название..."
                    }
                }
                8 -> {
                    if(database.nineDao().getTitle()?.title != null){
                        database.nineDao().getTitle()?.title.toString()
                    } else{
                        "напишите название..."
                    }
                }
                9 -> {
                    if(database.tenDao().getTitle()?.title != null){
                        database.tenDao().getTitle()?.title.toString()
                    } else{
                        "напишите название..."
                    }
                }
                10 -> {
                    if(database.elevenDao().getTitle()?.title != null){
                        database.elevenDao().getTitle()?.title.toString()
                    } else{
                        "напишите название..."
                    }
                }
                11 -> {
                    if(database.twelveDao().getTitle()?.title != null){
                        database.twelveDao().getTitle()?.title.toString()
                    } else{
                        "напишите название..."
                    }
                }
                12 -> {
                    if(database.thirteenDao().getTitle()?.title != null){
                        database.thirteenDao().getTitle()?.title.toString()
                    } else{
                        "напишите название..."
                    }
                }
                13 -> {
                    if(database.fourteenDao().getTitle()?.title != null){
                        database.fourteenDao().getTitle()?.title.toString()
                    } else{
                        "напишите название..."
                    }
                }
                14 -> {
                    if(database.fifteenDao().getTitle()?.title != null){
                        database.fifteenDao().getTitle()?.title.toString()
                    } else{
                        "напишите название..."
                    }
                }
                else -> "напишите название..."
            }
            val image = when (screen) {
                0 -> {
                    if(database.oneDao().getImage()?.image != null){
                        database.oneDao().getImage()?.image!!.toInt()
                    } else{
                        R.drawable.baseline_image_24
                    }
                }
                1 -> {
                    if(database.twoDao().getImage()?.image != null){
                        database.twoDao().getImage()?.image!!.toInt()
                    } else{
                        R.drawable.baseline_image_24
                    }
                }
                2 -> {
                    if(database.threeDao().getImage()?.image != null){
                        database.threeDao().getImage()?.image!!.toInt()
                    } else{
                        R.drawable.baseline_image_24
                    }
                }
                3 -> {
                    if(database.fourDao().getImage()?.image != null){
                        database.fourDao().getImage()?.image!!.toInt()
                    } else{
                        R.drawable.baseline_image_24
                    }
                }
                4 -> {
                    if(database.fiveDao().getImage()?.image != null){
                        database.fiveDao().getImage()?.image!!.toInt()
                    } else{
                        R.drawable.baseline_image_24
                    }
                }
                5 -> {
                    if(database.sixDao().getImage()?.image != null){
                        database.sixDao().getImage()?.image!!.toInt()
                    } else{
                        R.drawable.baseline_image_24
                    }
                }
                6 -> {
                    if(database.sevenDao().getImage()?.image != null){
                        database.sevenDao().getImage()?.image!!.toInt()
                    } else{
                        R.drawable.baseline_image_24
                    }
                }
                7 -> {
                    if(database.eightDao().getImage()?.image != null){
                        database.eightDao().getImage()?.image!!.toInt()
                    } else{
                        R.drawable.baseline_image_24
                    }
                }
                8 -> {
                    if(database.nineDao().getImage()?.image != null){
                        database.nineDao().getImage()?.image!!.toInt()
                    } else{
                        R.drawable.baseline_image_24
                    }
                }
                9 -> {
                    if(database.tenDao().getImage()?.image != null){
                        database.tenDao().getImage()?.image!!.toInt()
                    } else{
                        R.drawable.baseline_image_24
                    }
                }
                10 -> {
                    if(database.elevenDao().getImage()?.image != null){
                        database.elevenDao().getImage()?.image!!.toInt()
                    } else{
                        R.drawable.baseline_image_24
                    }
                }
                11 -> {
                    if(database.twelveDao().getImage()?.image != null){
                        database.twelveDao().getImage()?.image!!.toInt()
                    } else{
                        R.drawable.baseline_image_24
                    }
                }
                12 -> {
                    if(database.thirteenDao().getImage()?.image != null){
                        database.thirteenDao().getImage()?.image!!.toInt()
                    } else{
                        R.drawable.baseline_image_24
                    }
                }
                13 -> {
                    if(database.fourteenDao().getImage()?.image != null){
                        database.fourteenDao().getImage()?.image!!.toInt()
                    } else{
                        R.drawable.baseline_image_24
                    }
                }
                14 -> {
                    if(database.fifteenDao().getImage()?.image != null){
                        database.fifteenDao().getImage()?.image!!.toInt()
                    } else{
                        R.drawable.baseline_image_24
                    }
                }
                else -> R.drawable.baseline_image_24
            }
                Card(
                    modifier = Modifier
                        .padding(8.dp)
                        .size(150.dp)
                        .background(Color.Transparent)
                        .clickable {
                            if (title != "напишите название..." && image != R.drawable.baseline_image_24) {
                                navController.navigate(screens[screen])
                            } else {
                                navController.navigate("ResoursesScreen/$screen/$screen")
                            }
                        },
                    shape = CutCornerShape(
                        topStart = 4.dp,
                        topEnd = 4.dp,
                        bottomEnd = 4.dp,
                        bottomStart = 16.dp
                    ),
                ) {
                    Box(modifier = Modifier
                        .fillMaxSize()
                        .background(
                            brush = Brush.radialGradient(
                                colors = listOf(
                                    colorResource(id = R.color.lightblue),
                                    colorResource(id = R.color.milk)
                                ),
                                radius = 150f
                            )
                        )
                    ) {

                        Column {
                            Image( painter = painterResource(id = image),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(100.dp)
                                    .padding(start = 8.dp, top = 4.dp)
                               )
                            Text(text = title,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = colorResource(id = R.color.darkblue),
                                    fontFamily = FontFamily.Monospace,
                                    modifier = Modifier.padding(start = 8.dp, top = 4.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}

