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
    Fifteen::class], version = 1)
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
