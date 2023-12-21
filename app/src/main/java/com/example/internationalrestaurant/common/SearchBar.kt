package com.example.internationalrestaurant.common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    text: String,
    placeholder: String = "",
    onTextChange: (String) -> Unit,
    onClearClick: () -> Unit = {}
) {
    OutlinedTextField(
        modifier = modifier
            .fillMaxWidth()
            .padding(15.dp),
        value = text,
        onValueChange = onTextChange,
        placeholder = {
            Text(text = placeholder, modifier = Modifier.wrapContentHeight(), color = Color.Black)
        },
        leadingIcon = {
            Icon(imageVector = Icons.Default.Search, contentDescription = "Search")
        },
        trailingIcon = {
            IconButton(onClick = { onClearClick() }) {
                Icon(imageVector = Icons.Default.Close, contentDescription = "Clear")
            }
        },
        singleLine = true,
        maxLines = 1
    )
}