package com.komparo.helpfullinks.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController

@Composable
fun OneScreen(navController: NavController){
Box (modifier = Modifier.fillMaxSize().background(color = Color.Green), contentAlignment = Alignment.Center){
    Text(text = "One Screen", modifier = Modifier.clickable { navController.navigate("mainScreen")})
}
}