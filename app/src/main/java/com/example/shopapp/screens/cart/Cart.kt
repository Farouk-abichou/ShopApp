package com.example.shopapp.screens.cart

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.shopapp.screens.cart.components.CartSection
import com.example.shopapp.screens.product.components.ProductContent
import com.example.shopapp.util.AppColors


@Composable
fun Cart(navController: NavController,viewModel: CartViewModel = hiltViewModel()){
    var ScrollState= rememberScrollState()
    Column(
        modifier = Modifier
            .verticalScroll(ScrollState)
            .background(AppColors.mBackgroundColor)
            .fillMaxWidth()
    ) {
        CartSection(navController,viewModel)
    }
}