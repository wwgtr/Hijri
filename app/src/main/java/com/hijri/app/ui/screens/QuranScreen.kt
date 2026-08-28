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
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import com.hijri.app.ui.components.LiquidGlassContainer

/**
 * شاشة القرآن الكريم
 * Quran Screen with Liquid Glass UI
 */
@Composable
fun QuranScreen() {
    // تدرج لون خلفية
    val gradientBrush = Brush.verticalGradient(
        colors = listOf(
            Color(0xFF0F766E),
            Color(0xFF2D9B9B)
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
            // رأس الشاشة مع البحث
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { /* Search action */ }) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search",
                        tint = Color.White,
                        modifier = Modifier.width(24.dp)
                    )
                }
                Text(
                    text = "القرآن الكريم",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Icon(
                    imageVector = Icons.Default.Book,
                    contentDescription = "Quran",
                    tint = Color.White,
                    modifier = Modifier.width(24.dp)
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            // آخر سورة مقروءة
            LiquidGlassContainer(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                    horizontalAlignment = Alignment.End
                ) {
                    Text(
                        text = "آخر سورة مقروءة",
                        fontSize = 14.sp,
                        color = Color.White.copy(alpha = 0.8f)
                    )
                    Text(
                        text = "سورة البقرة",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                    Text(
                        text = "الآية 286",
                        fontSize = 14.sp,
                        color = Color.White.copy(alpha = 0.8f),
                        modifier = Modifier.padding(top = 4.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // قائمة السور
            Text(
                text = "السور الكريمة",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 16.dp),
                textAlign = androidx.compose.ui.text.style.TextAlign.End
            )

            Spacer(modifier = Modifier.height(12.dp))

            // عينة من السور
            repeat(5) { index ->
                LiquidGlassCard(
                    title = "السورة ${index + 1}",
                    content = listOf(
                        "الفاتحة",
                        "البقرة",
                        "آل عمران",
                        "النساء",
                        "المائدة"
                    )[index],
                    backgroundColor = Color.White.copy(alpha = 0.15f)
                )
            }

            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}
