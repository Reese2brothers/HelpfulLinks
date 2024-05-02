package com.komparo.helpfullinks.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.komparo.helpfullinks.data.dao.EightDao
import com.komparo.helpfullinks.data.dao.ElevenDao
import com.komparo.helpfullinks.data.dao.FifteenDao
import com.komparo.helpfullinks.data.dao.FiveDao
import com.komparo.helpfullinks.data.dao.FourDao
import com.komparo.helpfullinks.data.dao.FourteenDao
import com.komparo.helpfullinks.data.dao.NineDao
import com.komparo.helpfullinks.data.dao.OneDao
import com.komparo.helpfullinks.data.dao.ScreenEightDao
import com.komparo.helpfullinks.data.dao.ScreenElevenDao
import com.komparo.helpfullinks.data.dao.ScreenFifteenDao
import com.komparo.helpfullinks.data.dao.ScreenFiveDao
import com.komparo.helpfullinks.data.dao.ScreenFourDao
import com.komparo.helpfullinks.data.dao.ScreenFourteenDao
import com.komparo.helpfullinks.data.dao.ScreenNineDao
import com.komparo.helpfullinks.data.dao.ScreenOneDao
import com.komparo.helpfullinks.data.dao.ScreenSevenDao
import com.komparo.helpfullinks.data.dao.ScreenSixDao
import com.komparo.helpfullinks.data.dao.ScreenTenDao
import com.komparo.helpfullinks.data.dao.ScreenThirteenDao
import com.komparo.helpfullinks.data.dao.ScreenThreeDao
import com.komparo.helpfullinks.data.dao.ScreenTwelveDao
import com.komparo.helpfullinks.data.dao.ScreenTwoDao
import com.komparo.helpfullinks.data.dao.SevenDao
import com.komparo.helpfullinks.data.dao.SixDao
import com.komparo.helpfullinks.data.dao.TenDao
import com.komparo.helpfullinks.data.dao.ThirteenDao
import com.komparo.helpfullinks.data.dao.ThreeDao
import com.komparo.helpfullinks.data.dao.TwelveDao
import com.komparo.helpfullinks.data.dao.TwoDao
import com.komparo.helpfullinks.data.model.Eight
import com.komparo.helpfullinks.data.model.Eleven
import com.komparo.helpfullinks.data.model.Fifteen
import com.komparo.helpfullinks.data.model.Five
import com.komparo.helpfullinks.data.model.Four
import com.komparo.helpfullinks.data.model.Fourteen
import com.komparo.helpfullinks.data.model.Nine
import com.komparo.helpfullinks.data.model.One
import com.komparo.helpfullinks.data.model.ScreenEight
import com.komparo.helpfullinks.data.model.ScreenEleven
import com.komparo.helpfullinks.data.model.ScreenFifteen
import com.komparo.helpfullinks.data.model.ScreenFive
import com.komparo.helpfullinks.data.model.ScreenFour
import com.komparo.helpfullinks.data.model.ScreenFourteen
import com.komparo.helpfullinks.data.model.ScreenNine
import com.komparo.helpfullinks.data.model.ScreenOne
import com.komparo.helpfullinks.data.model.ScreenSeven
import com.komparo.helpfullinks.data.model.ScreenSix
import com.komparo.helpfullinks.data.model.ScreenTen
import com.komparo.helpfullinks.data.model.ScreenThirteen
import com.komparo.helpfullinks.data.model.ScreenThree
import com.komparo.helpfullinks.data.model.ScreenTwelve
import com.komparo.helpfullinks.data.model.ScreenTwo
import com.komparo.helpfullinks.data.model.Seven
import com.komparo.helpfullinks.data.model.Six
import com.komparo.helpfullinks.data.model.Ten
import com.komparo.helpfullinks.data.model.Thirteen
import com.komparo.helpfullinks.data.model.Three
import com.komparo.helpfullinks.data.model.Twelve
import com.komparo.helpfullinks.data.model.Two

@Database(entities = [One::class, Two::class,
   Three::class, Four::class, Five::class, Six::class, Seven::class, Eight::class,
    Nine::class, Ten::class, Eleven::class, Twelve::class, Thirteen::class, Fourteen::class,
    Fifteen::class, ScreenOne::class, ScreenTwo::class, ScreenThree::class, ScreenFour::class, ScreenFive::class,
                     ScreenSix::class, ScreenSeven::class, ScreenEight::class, ScreenNine::class,
                     ScreenTen::class, ScreenEleven::class, ScreenTwelve::class, ScreenThirteen::class,
                     ScreenFourteen::class, ScreenFifteen::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun oneDao(): OneDao
    abstract fun twoDao(): TwoDao
    abstract fun threeDao(): ThreeDao
    abstract fun fourDao(): FourDao
    abstract fun fiveDao(): FiveDao
    abstract fun sixDao(): SixDao
    abstract fun sevenDao(): SevenDao
    abstract fun eightDao(): EightDao
    abstract fun nineDao(): NineDao
    abstract fun tenDao(): TenDao
    abstract fun elevenDao(): ElevenDao
    abstract fun twelveDao(): TwelveDao
    abstract fun thirteenDao(): ThirteenDao
    abstract fun fourteenDao(): FourteenDao
    abstract fun fifteenDao(): FifteenDao
    abstract fun screenOneDao(): ScreenOneDao
    abstract fun screenTwoDao(): ScreenTwoDao
    abstract fun screenThreeDao(): ScreenThreeDao
    abstract fun screenFourDao(): ScreenFourDao
    abstract fun screenFiveDao(): ScreenFiveDao
    abstract fun screenSixDao(): ScreenSixDao
    abstract fun screenSevenDao(): ScreenSevenDao
    abstract fun screenEightDao(): ScreenEightDao
    abstract fun screenNineDao(): ScreenNineDao
    abstract fun screenTenDao(): ScreenTenDao
    abstract fun screenElevenDao(): ScreenElevenDao
    abstract fun screenTwelveDao(): ScreenTwelveDao
    abstract fun screenThirteenDao(): ScreenThirteenDao
    abstract fun screenFourteenDao(): ScreenFourteenDao
    abstract fun screenFifteenDao(): ScreenFifteenDao


    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "database")
                    .allowMainThreadQueries()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
    }
