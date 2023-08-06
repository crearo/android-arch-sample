package com.crearo.water.repo.consumed

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import java.time.Instant

@Entity(tableName = "WaterConsumed")
@TypeConverters(InstantTypeConverter::class)
class WaterConsumed(
    @PrimaryKey(autoGenerate = true) val id: Int, val time: Instant, val amount: Long
)

class InstantTypeConverter {
    @TypeConverter
    fun fromTimestamp(value: Long): Instant {
        return value.let { Instant.ofEpochMilli(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: Instant): Long {
        return date.toEpochMilli()
    }
}
