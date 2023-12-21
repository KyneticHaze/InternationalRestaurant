package com.example.internationalrestaurant.common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun TitleText(
    text : String,
    textColor : Color
) {
    Text(
        text = text,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        style = MaterialTheme.typography.headlineMedium,
        color = textColor
    )
}