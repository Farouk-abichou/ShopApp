package com.example.shopapp

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.shopapp.screens.cart.Cart
import com.example.shopapp.screens.home.ShopHome
import com.example.shopapp.screens.product.Product

@Composable
fun SetUpNavGraph(
    navController: NavHostController
){

    NavHost(
        navController = navController,
        startDestination = Screens.Home.route)
    {
        composable(
            route = Screens.Home.route
        ){
            ShopHome(navController)
        }
        composable(
            route = Screens.Product.route + "/{Id}",
            arguments = listOf(
                navArgument("Id"){
                    type= NavType.StringType
                    nullable=true
                },
            )
        ){
            Product(navController)

        }
        composable(
            route = Screens.Cart.route
//            arguments = listOf(
//                navArgument("Id"){
//                    type= NavType.StringType
//                    nullable=true
//                },
//            )
        ){
            Cart(navController)

        }


//        composable(
//            route = Screen.CreateNote.route + "/{Id}",
//            arguments = listOf(
//                navArgument("Id"){
//                    type= NavType.StringType
//                    nullable=true
//                },
//            )
//        ){
//            CreateNoteScreen(navController)
//        }
    }
}

