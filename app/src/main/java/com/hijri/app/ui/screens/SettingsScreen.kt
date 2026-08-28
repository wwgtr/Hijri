package com.hijri.app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hijri.app.ui.components.LiquidGlassCard
import com.hijri.app.ui.components.LiquidGlassContainer

/**
 * شاشة الإعدادات
 * Settings Screen with Liquid Glass UI
 */
@Composable
fun SettingsScreen() {
    // تدرج لون خلفية
    val gradientBrush = Brush.verticalGradient(
        colors = listOf(
            Color(0xFF4C1D95),
            Color(0xFF7C3AED)
        )
    )

    // حالات التبديل
    val notificationsEnabled = remember { mutableStateOf(true) }
    val alarmEnabled = remember { mutableStateOf(true) }
    val darkModeEnabled = remember { mutableStateOf(true) }

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
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "الإعدادات",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                IconButton(onClick = { /* Settings menu */ }) {
                    Icon(
                        imageVector = Icons.Default.Settings,
                        contentDescription = "Settings",
                        tint = Color.White,
                        modifier = Modifier.width(24.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // إعدادات الإشعارات
            Text(
                text = "الإشعارات",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 16.dp),
                textAlign = androidx.compose.ui.text.style.TextAlign.End
            )

            Spacer(modifier = Modifier.height(12.dp))

            // تفعيل الإشعارات
            LiquidGlassContainer(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Switch(
                        checked = notificationsEnabled.value,
                        onCheckedChange = { notificationsEnabled.value = it },
                        colors = SwitchDefaults.colors(
                            checkedThumbColor = Color.White,
                            checkedTrackColor = Color.Green.copy(alpha = 0.5f)
                        )
                    )
                    Text(
                        text = "إشعارات أوقات الصلاة",
                        fontSize = 14.sp,
                        color = Color.White,
                        modifier = Modifier.padding(end = 12.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // تفعيل المنبه
            LiquidGlassContainer(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Switch(
                        checked = alarmEnabled.value,
                        onCheckedChange = { alarmEnabled.value = it },
                        colors = SwitchDefaults.colors(
                            checkedThumbColor = Color.White,
                            checkedTrackColor = Color.Blue.copy(alpha = 0.5f)
                        )
                    )
                    Text(
                        text = "تفعيل منبهات الصلاة",
                        fontSize = 14.sp,
                        color = Color.White,
                        modifier = Modifier.padding(end = 12.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // إعدادات الوقت والموقع
            Text(
                text = "الوقت والموقع",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 16.dp),
                textAlign = androidx.compose.ui.text.style.TextAlign.End
            )

            Spacer(modifier = Modifier.height(12.dp))

            // تحديد المدينة
            LiquidGlassCard(
                title = "المدينة",
                content = "الرياض",
                backgroundColor = Color.White.copy(alpha = 0.15f)
            )

            LiquidGlassCard(
                title = "الدولة",
                content = "المملكة العربية السعودية",
                backgroundColor = Color.White.copy(alpha = 0.15f)
            )

            Spacer(modifier = Modifier.height(24.dp))

            // إعدادات العرض
            Text(
                text = "العرض والتطبيق",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 16.dp),
                textAlign = androidx.compose.ui.text.style.TextAlign.End
            )

            Spacer(modifier = Modifier.height(12.dp))

            // الوضع الليلي
            LiquidGlassContainer(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Switch(
                        checked = darkModeEnabled.value,
                        onCheckedChange = { darkModeEnabled.value = it },
                        colors = SwitchDefaults.colors(
                            checkedThumbColor = Color.White,
                            checkedTrackColor = Color.Purple.copy(alpha = 0.5f)
                        )
                    )
                    Text(
                        text = "الوضع الليلي",
                        fontSize = 14.sp,
                        color = Color.White,
                        modifier = Modifier.padding(end = 12.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}
