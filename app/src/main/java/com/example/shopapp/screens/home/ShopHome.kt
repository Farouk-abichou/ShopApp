package com.example.shopapp.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.shopapp.screens.home.components.ShopHomePage
import com.example.shopapp.screens.home.components.TopAppBar
import com.example.shopapp.util.AppColors

@Composable
fun ShopHome(navController: NavController,viewModel: ShopHomeViewModel = hiltViewModel()){

    Column(
        modifier = Modifier
            .background(AppColors.mBackgroundColor)
            .fillMaxWidth()
    ) {
        TopAppBar(Modifier)
        ShopHomePage(navController,viewModel)
    }

}

