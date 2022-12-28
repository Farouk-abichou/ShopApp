package com.example.shopapp.screens.product

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.shopapp.screens.product.components.ProductContent
import com.example.shopapp.util.AppColors

@Composable
fun Product(navController: NavController,viewModel: ProductViewModel = hiltViewModel()){
    Column(
        modifier = Modifier
            .background(AppColors.mBackgroundColor)
            .fillMaxWidth()
    ) {
        ProductContent(navController,viewModel)
    }
}