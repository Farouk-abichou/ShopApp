package com.example.shopapp

sealed class Screens(val route:String) {
    object Home : Screens(route = "home_screen")
    object Product : Screens(route = "Product_screen")
    object Cart : Screens(route="Cart_screen")
    object Login : Screens(route="Login_screen")

    fun withArgs( vararg args: Int?):String{
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}
