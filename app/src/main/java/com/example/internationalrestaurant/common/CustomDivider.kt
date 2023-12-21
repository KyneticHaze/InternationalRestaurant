package com.example.internationalrestaurant.common

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.internationalrestaurant.ui.theme.tertiary

@Composable
fun CustomDivider() {
    Divider(
        modifier = Modifier.padding(horizontal = 40.dp, vertical = 15.dp),
        color = tertiary,
        thickness = 2.dp
    )
}