package com.example.shopapp.screens.product

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.shopapp.screens.product.components.ProductPage

@Composable
fun Product(navController: NavController,viewModel: ProductViewModel = hiltViewModel()){
    ProductPage(navController,viewModel)
}