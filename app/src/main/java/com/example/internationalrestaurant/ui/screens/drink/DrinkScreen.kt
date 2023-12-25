package com.example.internationalrestaurant.ui.screens.drink

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.outlined.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.internationalrestaurant.R
import com.example.internationalrestaurant.ui.screens.drink.components.DrinkCard
import com.example.internationalrestaurant.ui.screens.drink.viewmodel.DrinkViewModel
import com.example.internationalrestaurant.common.SearchBar
import com.example.internationalrestaurant.common.TitleText
import com.example.internationalrestaurant.domain.model.Drink
import com.example.internationalrestaurant.ui.screens.drink.components.DrinkDetailCard
import com.example.internationalrestaurant.ui.theme.background
import com.example.internationalrestaurant.ui.theme.primary
import com.example.internationalrestaurant.ui.theme.secondary
import com.example.internationalrestaurant.ui.theme.tertiary

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun DrinkScreen(
    viewModel: DrinkViewModel = hiltViewModel()
) {

    val drinksState = viewModel.drinksState.value
    val searchQuery = viewModel.searchQuery.value
    val drinkDetailState = viewModel.drinkDetailState.value

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(background)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painterResource(id = R.drawable.logo_transparent),
                contentDescription = "International Restaurant",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            )
            TitleText(text = "Drinks", textColor = tertiary)
            SearchBar(
                text = searchQuery,
                onTextChange = { viewModel.searchDrink(it) },
                onClearClick = { viewModel.clearDrink() },
                placeholder = "Search Drink"
            )
            LazyVerticalGrid(columns = GridCells.Fixed(2)) {
                items(drinksState.drinks) {drink ->
                    DrinkCard(drink = drink) {
                        // Add Drink to Room
                        viewModel.addDrink(it)
                    }
                }
            }
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(12.dp)
            ) {
                Button(
                    onClick = {
                        viewModel.getDrinkDetail()
                    },
                    shape = RoundedCornerShape(5.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = secondary
                    )
                ) {
                    Text(text = "Random Drink")
                    Spacer(modifier = Modifier.width(8.dp))
                    Icon(
                        painterResource(id = R.drawable.zar),
                        contentDescription = "Random",
                        modifier = Modifier.size(32.dp)
                    )
                }
                Spacer(modifier = Modifier.width(12.dp))
                Button(
                    onClick = {
                        viewModel.clearDrinkDetail()
                    },
                    shape = RoundedCornerShape(5.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = secondary
                    )
                ) {
                    Text(text = "Clear Card")
                    Spacer(modifier = Modifier.width(8.dp))
                    Icon(
                        imageVector = Icons.Outlined.Clear,
                        contentDescription = "Clear",
                        modifier = Modifier.size(32.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.height(30.dp))
            drinkDetailState.drink?.let {
                DrinkDetailCard(drink = it)
            }
        }
    }
}