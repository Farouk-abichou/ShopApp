package com.example.shopapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.shopapp.screens.home.ShopHome
import com.example.shopapp.ui.theme.ShopAppTheme
import com.example.shopapp.util.AppColors
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    lateinit var navController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShopAppTheme {
                Surface(modifier = Modifier.fillMaxSize()
                ) {
                    navController= rememberNavController()

                    SetUpNavGraph(navController = navController)
                }
            }
        }
    }
}

