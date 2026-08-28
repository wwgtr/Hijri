package com.hijri.app.data.remote.api

import com.hijri.app.data.remote.dto.PrayerTimesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface PrayerTimesApiService {
    @GET("timings")
    suspend fun getPrayerTimes(
        @Query("city") city: String,
        @Query("country") country: String,
        @Query("method") method: Int = 2, // ISNA method
        @Query("school") school: Int = 0 // Jafari school
    ): PrayerTimesResponse
}
