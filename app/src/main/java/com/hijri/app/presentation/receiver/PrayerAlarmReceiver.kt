package com.hijri.app.presentation.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.hijri.app.presentation.notification.PrayerNotificationManager

class PrayerAlarmReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val prayerName = intent.getStringExtra("prayer_name") ?: "الصلاة"
        val prayerNameAr = intent.getStringExtra("prayer_name_ar") ?: "الصلاة"
        val notificationId = intent.getIntExtra("notification_id", 0)

        val notificationManager = PrayerNotificationManager(context)
        notificationManager.showPrayerAlarm(prayerName, prayerNameAr, notificationId)
    }
}
