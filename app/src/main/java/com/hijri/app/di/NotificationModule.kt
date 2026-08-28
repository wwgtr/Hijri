package com.hijri.app.di

import android.content.Context
import com.hijri.app.presentation.alarm.AlarmScheduler
import com.hijri.app.presentation.notification.PrayerNotificationManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NotificationModule {
    @Singleton
    @Provides
    fun providePrayerNotificationManager(
        @ApplicationContext context: Context
    ): PrayerNotificationManager = PrayerNotificationManager(context)

    @Singleton
    @Provides
    fun provideAlarmScheduler(
        @ApplicationContext context: Context
    ): AlarmScheduler = AlarmScheduler(context)
}
