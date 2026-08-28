package com.hijri.app.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.hijri.app.ui.navigation.HijriNavigation
import com.hijri.app.ui.theme.HijriTheme

@Composable
fun HijriApp() {
    HijriTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            HijriNavigation()
        }
    }
}
