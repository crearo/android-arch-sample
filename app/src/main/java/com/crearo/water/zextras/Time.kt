package com.crearo.water.zextras

import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZonedDateTime


val now: Instant
    get() = ZonedDateTime.now(ZoneId.systemDefault()).toInstant()


fun dayStart(instant: Instant): Instant {
    val zoneId = ZoneId.systemDefault()
    val localDate = LocalDateTime.ofInstant(instant, zoneId).toLocalDate()
    return localDate.atStartOfDay(zoneId).toInstant()
}

fun dayEnd(instant: Instant): Instant {
    val zoneId = ZoneId.systemDefault()
    val localDate = LocalDateTime.ofInstant(instant, zoneId).toLocalDate()
    return localDate.atTime(23, 59, 59).atZone(zoneId).toInstant()
}