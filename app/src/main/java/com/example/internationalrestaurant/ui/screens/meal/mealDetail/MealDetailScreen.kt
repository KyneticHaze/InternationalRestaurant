package com.example.internationalrestaurant.ui.screens.meal.mealDetail

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.internationalrestaurant.ui.theme.background
import com.example.internationalrestaurant.ui.theme.primary
import com.example.internationalrestaurant.ui.theme.tertiary

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun MealDetailScreen(
    viewModel: MealDetailViewModel = hiltViewModel()
) {

    val mealDetailState = viewModel.mealDetailState.value

    Surface(
        color = background,
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        mealDetailState.mealDetail?.let {

            Card(
                colors = CardDefaults.cardColors(
                    containerColor = background
                ),
                modifier = Modifier.padding(15.dp)
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    AsyncImage(
                        model = it.mealImg,
                        contentDescription = it.mealName,
                        modifier = Modifier.fillMaxWidth(),
                        contentScale = ContentScale.Fit
                    )
                    Text(
                        text = it.mealName.orEmpty(),
                        style = MaterialTheme.typography.headlineLarge,
                        color = primary
                    )
                    Text(
                        text = it.category.orEmpty(),
                        style = MaterialTheme.typography.headlineSmall,
                        color = tertiary
                    )
                    Text(
                        text = it.mealDesc.orEmpty(),
                        overflow = TextOverflow.Ellipsis,
                        fontStyle = FontStyle.Italic
                    )
                    Text(
                        text = it.mealCountry.orEmpty(),
                        style = MaterialTheme.typography.headlineMedium,
                        color = tertiary
                    )
                }
            }
        }
    }
}