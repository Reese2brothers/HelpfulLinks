package com.komparo.helpfullinks

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.res.colorResource
import androidx.navigation.compose.rememberNavController
import com.komparo.helpfullinks.screens.NavGraphNavigate

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScreenStatusBar(colorResource(id = R.color.darkblue))
            val navController = rememberNavController()
            NavGraphNavigate(this, navController)
        }
    }
}
