package com.hijri.app.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Watch
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.hijri.app.ui.screens.IslamicKnowledgeScreen
import com.hijri.app.ui.screens.PrayerTimesScreen
import com.hijri.app.ui.screens.QuranScreen
import com.hijri.app.ui.screens.SettingsScreen

sealed class NavScreen(val route: String, val label: String, val icon: ImageVector) {
    object PrayerTimes : NavScreen("prayer_times", "الصلوات", Icons.Default.Watch)
    object Quran : NavScreen("quran", "القرآن", Icons.Default.Book)
    object Knowledge : NavScreen("knowledge", "المعارف", Icons.Default.School)
    object Settings : NavScreen("settings", "الإعدادات", Icons.Default.Settings)
}

@Composable
fun HijriNavigation() {
    val currentScreen = remember { mutableStateOf<NavScreen>(NavScreen.PrayerTimes) }

    Scaffold(
        bottomBar = {
            NavigationBar(
                containerColor = Color.White.copy(alpha = 0.15f),
                contentColor = Color.White
            ) {
                val screens = listOf(
                    NavScreen.PrayerTimes,
                    NavScreen.Quran,
                    NavScreen.Knowledge,
                    NavScreen.Settings
                )

                screens.forEach { screen ->
                    NavigationBarItem(
                        icon = {
                            Icon(
                                imageVector = screen.icon,
                                contentDescription = screen.label
                            )
                        },
                        label = { Text(screen.label) },
                        selected = currentScreen.value == screen,
                        onClick = { currentScreen.value = screen },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Color.White,
                            selectedTextColor = Color.White,
                            unselectedIconColor = Color.White.copy(alpha = 0.6f),
                            unselectedTextColor = Color.White.copy(alpha = 0.6f),
                            indicatorColor = Color.White.copy(alpha = 0.2f)
                        )
                    )
                }
            }
        }
    ) { innerPadding ->
        when (currentScreen.value) {
            NavScreen.PrayerTimes -> PrayerTimesScreen()
            NavScreen.Quran -> QuranScreen()
            NavScreen.Knowledge -> IslamicKnowledgeScreen()
            NavScreen.Settings -> SettingsScreen()
        }
    }
}
