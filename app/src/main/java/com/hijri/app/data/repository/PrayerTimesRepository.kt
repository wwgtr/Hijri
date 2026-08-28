package com.hijri.app.data.repository

import com.hijri.app.data.local.dao.PrayerTimeDao
import com.hijri.app.data.local.entity.PrayerTimeEntity
import com.hijri.app.data.remote.api.PrayerTimesApiService
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PrayerTimesRepository @Inject constructor(
    private val prayerTimeDao: PrayerTimeDao,
    private val apiService: PrayerTimesApiService
) {
    fun getPrayerTimeByDate(date: String): Flow<PrayerTimeEntity?> =
        prayerTimeDao.getPrayerTimeByDate(date)

    fun getLatestPrayerTime(city: String): Flow<PrayerTimeEntity?> =
        prayerTimeDao.getLatestPrayerTime(city)

    fun getAllPrayerTimes(): Flow<List<PrayerTimeEntity>> =
        prayerTimeDao.getAllPrayerTimes()

    suspend fun fetchAndSavePrayerTimes(city: String, country: String) {
        try {
            val response = apiService.getPrayerTimes(city, country)
            // Process and save to database
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
