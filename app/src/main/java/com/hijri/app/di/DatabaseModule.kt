package com.hijri.app.di

import android.content.Context
import com.hijri.app.data.local.HijriDatabase
import com.hijri.app.data.local.dao.PrayerTimeDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Singleton
    @Provides
    fun provideHijriDatabase(
        @ApplicationContext context: Context
    ): HijriDatabase = HijriDatabase.getInstance(context)

    @Singleton
    @Provides
    fun providePrayerTimeDao(database: HijriDatabase): PrayerTimeDao =
        database.prayerTimeDao()
}
