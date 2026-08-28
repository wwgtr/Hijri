package com.hijri.app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hijri.app.ui.components.LiquidGlassCard
import com.hijri.app.ui.components.LiquidGlassPrayerCard

/**
 * شاشة أوقات الصلاة الرئيسية
 * Main Prayer Times Screen with Liquid Glass UI
 */
@Composable
fun PrayerTimesScreen() {
    // تدرج لون خلفية جميل
    val gradientBrush = Brush.verticalGradient(
        colors = listOf(
            Color(0xFF6750A4),
            Color(0xFF8B5CF6)
        )
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(gradientBrush)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // رأس الشاشة
            Text(
                text = "أوقات الصلاة",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(top = 16.dp)
            )

            Text(
                text = "الرياض",
                fontSize = 16.sp,
                color = Color.White.copy(alpha = 0.8f),
                modifier = Modifier.padding(bottom = 24.dp)
            )

            // الصلاة القادمة
            LiquidGlassCard(
                title = "الصلاة القادمة",
                content = "الظهر",
                backgroundColor = Color.White.copy(alpha = 0.2f)
            )

            Spacer(modifier = Modifier.height(8.dp))

            // الوقت المتبقي
            LiquidGlassCard(
                title = "الوقت المتبقي",
                content = "2:45:30",
                backgroundColor = Color(0xFF4CAF50).copy(alpha = 0.2f)
            )

            Spacer(modifier = Modifier.height(24.dp))

            // عنوان الصلوات
            Text(
                text = "أوقات الصلوات الخمس",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp),
                textAlign = androidx.compose.ui.text.style.TextAlign.End
            )

            Spacer(modifier = Modifier.height(12.dp))

            // الصلاة الأولى: الفجر
            LiquidGlassPrayerCard(
                prayerName = "Fajr",
                prayerNameAr = "الفجر",
                time = "04:30"
            )

            // الصلاة الثانية: الظهر
            LiquidGlassPrayerCard(
                prayerName = "Dhuhr",
                prayerNameAr = "الظهر",
                time = "12:15"
            )

            // الصلاة الثالثة: العصر
            LiquidGlassPrayerCard(
                prayerName = "Asr",
                prayerNameAr = "العصر",
                time = "15:45"
            )

            // الصلاة الرابعة: المغرب
            LiquidGlassPrayerCard(
                prayerName = "Maghrib",
                prayerNameAr = "المغرب",
                time = "18:30"
            )

            // الصلاة الخامسة: العشاء
            LiquidGlassPrayerCard(
                prayerName = "Isha",
                prayerNameAr = "العشاء",
                time = "20:00"
            )

            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}
