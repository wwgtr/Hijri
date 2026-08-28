package com.hijri.app.domain.usecase

import com.hijri.app.data.local.entity.PrayerTimeEntity
import com.hijri.app.data.repository.PrayerTimesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPrayerTimesUseCase @Inject constructor(
    private val repository: PrayerTimesRepository
) {
    operator fun invoke(date: String): Flow<PrayerTimeEntity?> =
        repository.getPrayerTimeByDate(date)
}
