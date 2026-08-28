package com.hijri.app.data.remote.dto

data class PrayerTimesResponse(
    val code: Int,
    val status: String,
    val data: PrayerTimesData
)

data class PrayerTimesData(
    val timings: Map<String, String>,
    val date: DateInfo,
    val meta: MetaInfo
)

data class DateInfo(
    val readable: String,
    val timestamp: String,
    val hijri: HijriDate,
    val gregorian: GregorianDate
)

data class HijriDate(
    val date: String,
    val format: String,
    val day: String,
    val weekday: WeekdayInfo,
    val month: MonthInfo,
    val year: String
)

data class GregorianDate(
    val date: String,
    val format: String,
    val day: String,
    val weekday: WeekdayInfo,
    val month: MonthInfo,
    val year: String
)

data class WeekdayInfo(
    val en: String,
    val ar: String
)

data class MonthInfo(
    val number: Int,
    val en: String,
    val ar: String
)

data class MetaInfo(
    val latitude: Double,
    val longitude: Double,
    val timezone: String,
    val method: MethodInfo
)

data class MethodInfo(
    val id: Int,
    val name: String,
    val params: Map<String, String>
)
