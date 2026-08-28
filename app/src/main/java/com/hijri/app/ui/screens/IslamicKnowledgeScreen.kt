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
import androidx.compose.material.icons.filled.Help
import androidx.compose.material.icons.filled.School
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
import com.hijri.app.ui.components.LiquidGlassContainer

/**
 * شاشة الفقه والمعارف الإسلامية
 * Islamic Knowledge Screen with Liquid Glass UI
 */
@Composable
fun IslamicKnowledgeScreen() {
    // تدرج لون خلفية
    val gradientBrush = Brush.verticalGradient(
        colors = listOf(
            Color(0xFF7C2D12),
            Color(0xFFA16207)
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
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { /* Help action */ }) {
                    Icon(
                        imageVector = Icons.Default.Help,
                        contentDescription = "Help",
                        tint = Color.White,
                        modifier = Modifier.width(24.dp)
                    )
                }
                Text(
                    text = "المعارف الإسلامية",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Icon(
                    imageVector = Icons.Default.School,
                    contentDescription = "Knowledge",
                    tint = Color.White,
                    modifier = Modifier.width(24.dp)
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            // قسم الفقه
            Text(
                text = "الفقه الإسلامي",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 16.dp),
                textAlign = androidx.compose.ui.text.style.TextAlign.End
            )

            Spacer(modifier = Modifier.height(12.dp))

            // عينة من مواضيع الفقه
            val fiqhTopics = listOf(
                "الطهارة" to "أحكام الطهارة والوضوء والتيمم",
                "الصلاة" to "أركان الصلاة وشروطها وواجباتها",
                "الزكاة" to "أنواع الزكاة ومقاديرها",
                "الحج" to "مناسك الحج والعمرة"
            )

            fiqhTopics.forEach { (title, description) ->
                LiquidGlassContainer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalAlignment = Alignment.End
                    ) {
                        Text(
                            text = title,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                        Text(
                            text = description,
                            fontSize = 12.sp,
                            color = Color.White.copy(alpha = 0.8f),
                            modifier = Modifier.padding(top = 8.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // قسم السؤال والجواب
            Text(
                text = "سؤال وجواب",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 16.dp),
                textAlign = androidx.compose.ui.text.style.TextAlign.End
            )

            Spacer(modifier = Modifier.height(12.dp))

            // عينة من الأسئلة والأجوبة
            val qaList = listOf(
                "ما هي شروط الصلاة المقبولة؟" to "من شروط الصلاة: الطهارة، ستر العورة، استقبال القبلة...",
                "متى تجب الزكاة؟" to "تجب الزكاة في الأموال إذا بلغت النصاب...",
                "كم تاج مكسير الوضوء؟" to "مكسيرات الوضوء هي: الجهل، البول، الغائط..."
            )

            qaList.forEach { (question, answer) ->
                LiquidGlassContainer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalAlignment = Alignment.End
                    ) {
                        Text(
                            text = question,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.White
                        )
                        Text(
                            text = answer,
                            fontSize = 12.sp,
                            color = Color.White.copy(alpha = 0.8f),
                            modifier = Modifier.padding(top = 8.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}
