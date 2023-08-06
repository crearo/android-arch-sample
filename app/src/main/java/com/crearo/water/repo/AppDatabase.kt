package com.crearo.water.repo

import androidx.room.Database
import androidx.room.RoomDatabase
import com.crearo.water.repo.consumed.WaterConsumed
import com.crearo.water.repo.consumed.WaterConsumedDao

@Database(
    entities = [WaterConsumed::class], version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun waterConsumedDao(): WaterConsumedDao
}
