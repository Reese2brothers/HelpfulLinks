package com.komparo.helpfullinks

import android.os.Bundle
import android.view.Window
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.res.colorResource
import androidx.navigation.compose.rememberNavController
import androidx.room.RoomDatabase
import com.komparo.helpfullinks.data.AppDatabase
import com.komparo.helpfullinks.screens.NavGraphNavigate
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.qualifiers.ApplicationContext

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var database : AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        database = AppDatabase.getDatabase(this)
        setContent {
            ScreenStatusBar(colorResource(id = R.color.darkblue))
            val navController = rememberNavController()
            NavGraphNavigate(database,this, navController)
        }
    }
}
