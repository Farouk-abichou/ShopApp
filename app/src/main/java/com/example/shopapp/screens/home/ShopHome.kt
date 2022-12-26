package com.example.shopapp.screens.home

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.shopapp.screens.home.components.ShopHomePage

@Composable
fun ShopHome(viewModel: ShopHomeViewModel = hiltViewModel()){
    val product = viewModel.data.value.data?.toMutableList() //Important!

    ShopHomePage(viewModel)
}

