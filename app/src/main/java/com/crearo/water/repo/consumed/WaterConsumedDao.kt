package com.crearo.water.repo.consumed

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface WaterConsumedDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(waterConsumed: WaterConsumed)

    @Query("SELECT SUM(amount) FROM WaterConsumed WHERE time >= :startOfDayMillis AND time <= :endOfDayMillis")
    suspend fun getTotalWaterConsumed(startOfDayMillis: Long, endOfDayMillis: Long): Flow<Long>

}