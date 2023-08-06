package com.crearo.water.repo

import com.crearo.water.zextras.dayEnd
import com.crearo.water.zextras.dayStart
import com.crearo.water.zextras.now
import kotlinx.coroutines.flow.Flow
import java.time.Instant
import javax.inject.Inject

class WaterConsumedRepo @Inject constructor(private val waterConsumedDao: WaterConsumedDao) {

    suspend fun addWaterConsumed(waterConsumed: WaterConsumed) {
        waterConsumedDao.insert(waterConsumed)
    }

    suspend fun getWaterConsumedToday(): Flow<Long> {
        return getWaterConsumed(dayStart(now), dayEnd(now))
    }

    suspend fun getWaterConsumed(dayStart: Instant, dayEnd: Instant): Flow<Long> {
        return waterConsumedDao.getTotalWaterConsumed(
            dayStart.toEpochMilli(), dayEnd.toEpochMilli()
        )
    }

}