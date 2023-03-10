package com.example.shopapp.screens.cart

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.shopapp.screens.cart.components.CartProducts
import com.example.shopapp.screens.cart.components.CartSection
import com.example.shopapp.screens.home.components.TopAppBar
import com.example.shopapp.util.AppColors


@Composable
fun Cart(navController: NavController,viewModel: CartViewModel = hiltViewModel()){
    Column(
        modifier = Modifier
//            .verticalScroll(ScrollState)
            .background(AppColors.mBackgroundColor)
            .fillMaxSize()
            .padding(start = 30.dp, end = 30.dp, top = 20.dp)
    ) {
        TopAppBar(navController,modifier = Modifier)
        Spacer(modifier = Modifier.height(10.dp))
        CartProducts(viewModel)
        CartSection(viewModel)
    }
}