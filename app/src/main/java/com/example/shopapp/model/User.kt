package com.example.shopapp.model

data class User(
    val id:Int,
    val email:String,
    val username:String,
    val password:String,
    val name: UserName,
    val adress: adress,
    val phone:String,
)


data class UserName(
    val firstname:String,
    val lastname:String,
)

data class adress(
    val city:String,
    val street:String,
    val number:Int,
    val zipcode:String,
    val geolocation:AdressGeolocation,

)
data class AdressGeolocation(
    val lat:String,
    val long:String,

)