package com.hijri.app.presentation.notification

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.hijri.app.R
import com.hijri.app.ui.MainActivity
import java.util.Calendar

class PrayerNotificationManager(private val context: Context) {
    private val notificationManager = NotificationManagerCompat.from(context)

    fun showPrayerTimeNotification(
        prayerName: String,
        prayerNameAr: String,
        prayerTime: String,
        notificationId: Int
    ) {
        val intent = Intent(context, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        val pendingIntent: PendingIntent = PendingIntent.getActivity(
            context,
            0,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        val notification = NotificationCompat.Builder(
            context,
            NotificationChannels.PRAYER_TIMES_CHANNEL_ID
        )
            .setSmallIcon(R.drawable.ic_prayer) // You need to add this icon
            .setContentTitle(prayerNameAr)
            .setContentText("الوقت: $prayerTime")
            .setStyle(
                NotificationCompat.BigTextStyle()
                    .bigText("حان الآن وقت صلاة $prayerNameAr في $prayerTime")
            )
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .build()

        notificationManager.notify(notificationId, notification)
    }

    fun showPrayerAlarm(
        prayerName: String,
        prayerNameAr: String,
        notificationId: Int
    ) {
        val intent = Intent(context, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        val pendingIntent: PendingIntent = PendingIntent.getActivity(
            context,
            0,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        val notification = NotificationCompat.Builder(
            context,
            NotificationChannels.PRAYER_ALARM_CHANNEL_ID
        )
            .setSmallIcon(R.drawable.ic_prayer)
            .setContentTitle("منبه الصلاة")
            .setContentText(prayerNameAr)
            .setStyle(
                NotificationCompat.BigTextStyle()
                    .bigText("حان وقت صلاة $prayerNameAr")
            )
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
            .setPriority(NotificationCompat.PRIORITY_MAX)
            .setFullScreenIntent(pendingIntent, true)
            .build()

        notificationManager.notify(notificationId, notification)
    }

    fun showDailyIslmicTip(
        title: String,
        message: String,
        notificationId: Int
    ) {
        val intent = Intent(context, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        val pendingIntent: PendingIntent = PendingIntent.getActivity(
            context,
            0,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        val notification = NotificationCompat.Builder(
            context,
            NotificationChannels.KNOWLEDGE_CHANNEL_ID
        )
            .setSmallIcon(R.drawable.ic_knowledge)
            .setContentTitle(title)
            .setContentText(message)
            .setStyle(
                NotificationCompat.BigTextStyle()
                    .bigText(message)
            )
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .build()

        notificationManager.notify(notificationId, notification)
    }
}
