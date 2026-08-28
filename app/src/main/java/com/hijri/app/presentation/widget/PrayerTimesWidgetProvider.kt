package com.hijri.app.presentation.widget

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.res.Configuration
import android.widget.RemoteViews
import com.hijri.app.R

class PrayerTimesWidgetProvider : AppWidgetProvider() {
    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        for (appWidgetId in appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId)
        }
    }

    private fun updateAppWidget(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetId: Int
    ) {
        val views = RemoteViews(context.packageName, R.layout.widget_prayer_times)

        // Check if RTL is enabled
        val isRtl =
            context.resources.configuration.layoutDirection == Configuration.LAYOUT_DIRECTION_RTL

        // Update widget with prayer times
        views.setTextViewText(R.id.widget_title, "أوقات الصلاة")
        views.setTextViewText(R.id.widget_fajr_time, "04:30")
        views.setTextViewText(R.id.widget_dhuhr_time, "12:15")
        views.setTextViewText(R.id.widget_asr_time, "15:45")
        views.setTextViewText(R.id.widget_maghrib_time, "18:30")
        views.setTextViewText(R.id.widget_isha_time, "20:00")

        appWidgetManager.updateAppWidget(appWidgetId, views)
    }
}
