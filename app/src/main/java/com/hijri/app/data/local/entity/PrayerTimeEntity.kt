package com.hijri.app.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity(tableName = "prayer_times")
data class PrayerTimeEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val fajrTime: LocalDateTime,
    val dhuhrTime: LocalDateTime,
    val asrTime: LocalDateTime,
    val maghribTime: LocalDateTime,
    val ishaTime: LocalDateTime,
    val date: String,
    val city: String,
    val latitude: Double,
    val longitude: Double,
    val createdAt: LocalDateTime = LocalDateTime.now()
)
