package com.example.shopapp.screens.cart.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shopapp.screens.cart.CartViewModel
import com.example.shopapp.screens.home.components.ProductImage
import kotlin.math.roundToInt


@Composable
fun ProductToBuy(
    viewModel: CartViewModel,
    id:Int,
    title: String,
    details: String,
    Price: Double,
    image: String,

){

    viewModel.price.value=Price

    val quantity: MutableState<Int> = remember {
        mutableStateOf(1)
    }

    val finalPrice =(quantity.value * viewModel.price.value * 100.0).roundToInt() / 100.0
//    viewModel.finalPrice.value = finalPrice.roundToInt()

    LaunchedEffect(key1 = Unit) {
        Log.d("tag77",viewModel.finalPrice.value.toString())
    }

    Row(modifier = Modifier
        .fillMaxWidth()
        .background(Color.Transparent)
        .padding(
            bottom = 20.dp
        )) {
        Box(
            modifier = Modifier
                .shadow(4.dp, RoundedCornerShape(10.dp))
                .clip(RoundedCornerShape(10.dp))
                .background(Color.White)
        ){
            ProductImage(
                modifier = Modifier,
                image = image,
                85.dp,
                120.dp)
        }
        Spacer(modifier = Modifier.width(10.dp))
        Column( Modifier.height(120.dp),
            verticalArrangement = Arrangement.SpaceBetween) {
            Column(){
                Row(
                    Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.Top,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = title,
                        modifier = Modifier.width(210.dp),
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "x", modifier = Modifier.clickable {
                            viewModel.deleteCartProducts(id = id)
                        },

                        color = Color.Gray,
                        fontSize = 15.sp
                    )
                    Spacer(modifier = Modifier.width(10.dp))


                }
                Text(
                    text = details, modifier = Modifier,
                    color = Color.Gray,
                    fontSize = 12.sp
                )
            }
            Spacer(modifier = Modifier.width(40.dp))
            Row(Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween) {
                Text(text = "$${finalPrice}",
                    modifier = Modifier,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.ExtraBold
                )
//                Row(modifier = Modifier
//                    .border(1.dp, Color.Gray, RoundedCornerShape(20.dp))
//                    .clip(RoundedCornerShape(20.dp))
//                    .background(Color.White)
//                    .padding(horizontal = 20.dp, vertical = 7.dp)) {
//                    Text(text = "- ", modifier = Modifier.clickable {
//                        if (quantity.value>1){
//                            quantity.value--
//                        }
//                    })
//
//                    Text(text = "${quantity.value}", modifier = Modifier.padding(horizontal = 15.dp), fontFamily = FontFamily(
//                        Font(
//                        R.font.bergentext_regular)
//                    )
//                    )
//
//                    Text(text = " +", modifier = Modifier.clickable {
//                        if (quantity.value<20){
//                            quantity.value++
//                        }
//                    })
//
//
//                }
//                    CircleButton(source= R.drawable.ic_baseline_add_24, Color.White ){
////                        if (viewModel.reputationOfProduct.value<1){
//                            viewModel.reputationOfProduct.value--
////                        }
//                    }
            }
        }

    }

}