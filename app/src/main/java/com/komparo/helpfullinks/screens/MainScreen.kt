package com.komparo.helpfullinks.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
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


@Composable
fun NavGraphNavigate(navController: NavHostController) {
    val imageId = remember { mutableStateOf(mapOf<Int, Int>()) }
    val screenTexts = remember { mutableStateOf(mapOf<String, String>()) }

    NavHost(navController = navController, startDestination = "mainScreen"){
        composable("mainScreen"){
            MainScreen(navController = navController, screenTexts = screenTexts, imageId = imageId)
        }
        composable("mainScreen/{text}/{image}"){
            MainScreen(navController, screenTexts, imageId)
        }
        composable("ResoursesScreen/{text}/{image}") {backStackEntry ->
            val text = backStackEntry.arguments?.getString("text") ?: ""
            ResourcesScreen(navController, text, screenTexts, imageId)
        }
        composable("OneScreen"){
            OneScreen(navController)
        }
        composable("TwoScreen"){
            TwoScreen(navController)
        }
        composable("ThreeScreen"){
            ThreeScreen(navController)
        }
        composable("FourScreen"){
            FourScreen(navController)
        }
        composable("FiveScreen"){
            FiveScreen(navController)
        }
        composable("SixScreen"){
            SixScreen(navController)
        }
        composable("SevenScreen"){
            SevenScreen(navController)
        }
        composable("EightScreen"){
            EightScreen(navController)
        }
        composable("NineScreen"){
            NineScreen(navController)
        }
        composable("TenScreen"){
            TenScreen(navController)
        }
        composable("ElevenScreen"){
            ElevenScreen(navController)
        }
        composable("TwelveScreen"){
            TwelveScreen(navController)
        }
        composable("ThirteenScreen"){
            ThirteenScreen(navController)
        }
        composable("FourteenScreen"){
            FourteenScreen(navController)
        }
        composable("FifteenScreen"){
            FifteenScreen(navController)
        }
    }
}

@Composable
fun MainScreen(navController: NavController, screenTexts: MutableState<Map<String, String>>, imageId : MutableState<Map<Int, Int>>) {
    val screens = listOf("OneScreen", "TwoScreen", "ThreeScreen", "FourScreen", "FiveScreen",
        "SixScreen", "SevenScreen", "EightScreen", "NineScreen", "TenScreen", "ElevenScreen",
        "TwelveScreen", "ThirteenScreen", "FourteenScreen", "FifteenScreen")

    Box(modifier = Modifier
        .fillMaxSize()
        .background(
            brush = Brush.verticalGradient(colors = listOf(Color.White, Color.Cyan))
        )
        .drawBehind {
            val circleOffset = size.width * 0.5f
            drawCircle(
                radius = 300.dp.toPx(),
                brush = Brush.horizontalGradient(colors = listOf(Color.White, Color(0xFF616061))),
                center = Offset(x = circleOffset / 1.5f, y = size.height / 1.1f)
            )
        }) {
        Text(text = "Полезные ссылки",
            fontSize = 34.sp,
            fontWeight = FontWeight.Bold,
            color = Color.DarkGray, fontFamily = FontFamily.Monospace,
            modifier = Modifier
                .padding(top = 8.dp)
                .align(alignment = Alignment.TopCenter))
        LazyVerticalGrid(GridCells.Fixed(2), modifier = Modifier.padding(top = 64.dp)){
            items(15) { screen ->
                Card(
                    modifier = Modifier
                        .padding(8.dp)
                        .size(150.dp)
                        .background(Color.Transparent)
                        .clickable { navController.navigate("ResoursesScreen/$screen/$screen") },
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
                                    Color.White,
                                    Color.Gray
                                )
                            )
                        )
                    ) {
                        Column {
                            Image(modifier = Modifier.size(100.dp),
                                painter = painterResource(id = imageId.value[screen] ?: R.drawable.baseline_image_24) ,
                                contentDescription = null)
                            Text(text = screenTexts.value[screen.toString()] ?: "напишите название...",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black, fontFamily = FontFamily.Monospace,
                                modifier = Modifier.padding(start = 8.dp, top = 8.dp))
                        }
                    }
                }
            }
        }
    }
}

