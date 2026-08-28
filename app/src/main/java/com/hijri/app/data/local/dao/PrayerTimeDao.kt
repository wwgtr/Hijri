package com.hijri.app.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.hijri.app.data.local.entity.PrayerTimeEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PrayerTimeDao {
    @Insert
    suspend fun insertPrayerTime(prayerTime: PrayerTimeEntity)

    @Update
    suspend fun updatePrayerTime(prayerTime: PrayerTimeEntity)

    @Delete
    suspend fun deletePrayerTime(prayerTime: PrayerTimeEntity)

    @Query("SELECT * FROM prayer_times WHERE date = :date LIMIT 1")
    fun getPrayerTimeByDate(date: String): Flow<PrayerTimeEntity?>

    @Query("SELECT * FROM prayer_times WHERE city = :city ORDER BY date DESC LIMIT 1")
    fun getLatestPrayerTime(city: String): Flow<PrayerTimeEntity?>

    @Query("SELECT * FROM prayer_times ORDER BY date DESC")
    fun getAllPrayerTimes(): Flow<List<PrayerTimeEntity>>
}
