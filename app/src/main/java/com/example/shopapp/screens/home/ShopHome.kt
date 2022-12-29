package com.example.shopapp.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.shopapp.screens.home.components.ProductsGrid
import com.example.shopapp.screens.home.components.ShopHomePage
import com.example.shopapp.screens.home.components.TopAppBar
import com.example.shopapp.util.AppColors

@Composable
fun ShopHome(navController: NavController,viewModel: ShopHomeViewModel = hiltViewModel()){


    Column(
        modifier = Modifier
            .background(AppColors.mBackgroundColor)
            .fillMaxSize()
            .padding(20.dp)
    ) {
        TopAppBar(navController,Modifier.padding(horizontal = 10.dp))
        Column(modifier = Modifier){
            Column(modifier =Modifier.padding(horizontal = 10.dp)) {
                ShopHomePage(Modifier,navController,viewModel)
            }
            ProductsGrid(modifier = Modifier,viewModel,navController)
        }

    }

}

