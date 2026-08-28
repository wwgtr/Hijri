package com.hijri.app.domain.model

import java.time.LocalDateTime

data class Prayer(
    val id: Int,
    val name: String,
    val nameAr: String,
    val time: LocalDateTime,
    val duration: Int, // in minutes
    val isNotified: Boolean = false
)

sealed class PrayerType(val id: Int, val name: String, val nameAr: String) {
    object Fajr : PrayerType(1, "Fajr", "الفجر")
    object Dhuhr : PrayerType(2, "Dhuhr", "الظهر")
    object Asr : PrayerType(3, "Asr", "العصر")
    object Maghrib : PrayerType(4, "Maghrib", "المغرب")
    object Isha : PrayerType(5, "Isha", "العشاء")
}
