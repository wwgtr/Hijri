package com.hijri.app.presentation.notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.media.AudioAttributes
import android.os.Build
import androidx.core.app.NotificationCompat

object NotificationChannels {
    const val PRAYER_TIMES_CHANNEL_ID = "prayer_times_channel"
    const val PRAYER_ALARM_CHANNEL_ID = "prayer_alarm_channel"
    const val QURAN_CHANNEL_ID = "quran_channel"
    const val KNOWLEDGE_CHANNEL_ID = "knowledge_channel"

    fun createNotificationChannels(context: Context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationManager =
                context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

            // Prayer Times Channel
            val prayerTimesChannel = NotificationChannel(
                PRAYER_TIMES_CHANNEL_ID,
                "أوقات الصلاة",
                NotificationManager.IMPORTANCE_HIGH
            ).apply {
                description = "إشعارات أوقات الصلاة"
                enableVibration(true)
                setSound(
                    android.provider.Settings.System.DEFAULT_NOTIFICATION_URI,
                    AudioAttributes.Builder()
                        .setUsage(AudioAttributes.USAGE_NOTIFICATION)
                        .build()
                )
            }

            // Prayer Alarm Channel
            val prayerAlarmChannel = NotificationChannel(
                PRAYER_ALARM_CHANNEL_ID,
                "منبه الصلاة",
                NotificationManager.IMPORTANCE_MAX
            ).apply {
                description = "منبهات صوتية للصلوات"
                enableVibration(true)
                setSound(
                    android.provider.Settings.System.DEFAULT_ALARM_ALERT_URI,
                    AudioAttributes.Builder()
                        .setUsage(AudioAttributes.USAGE_ALARM)
                        .build()
                )
            }

            // Quran Channel
            val quranChannel = NotificationChannel(
                QURAN_CHANNEL_ID,
                "القرآن الكريم",
                NotificationManager.IMPORTANCE_DEFAULT
            ).apply {
                description = "إشعارات القرآن الكريم"
            }

            // Knowledge Channel
            val knowledgeChannel = NotificationChannel(
                KNOWLEDGE_CHANNEL_ID,
                "المعارف الإسلامية",
                NotificationManager.IMPORTANCE_DEFAULT
            ).apply {
                description = "إشعارات المعارف والفقه الإسلامي"
            }

            notificationManager.createNotificationChannels(
                listOf(
                    prayerTimesChannel,
                    prayerAlarmChannel,
                    quranChannel,
                    knowledgeChannel
                )
            )
        }
    }
}
