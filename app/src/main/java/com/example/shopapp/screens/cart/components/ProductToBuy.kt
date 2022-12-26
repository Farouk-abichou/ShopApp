package com.example.shopapp.screens.cart.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shopapp.R
import com.example.shopapp.screens.home.components.CanImage
import com.example.shopapp.screens.home.components.CircleButton


@Preview(showBackground = true)
@Composable
fun ProductToBuy(
    title:String="Title",
    details:String="Details",
    Price:Double=9.99,

){
    val finalPriceOfOneProduct:MutableState<Double> = remember {
        mutableStateOf(Price)
    }

    val numberOfProduct:MutableState<Int> = remember {
        mutableStateOf(1)
    }

    Row(modifier = Modifier.fillMaxWidth()) {
        
        CanImage(modifier = Modifier, image = R.drawable.img_1,100.dp,100.dp)
        Column( Modifier.height(100.dp),verticalArrangement = Arrangement.SpaceEvenly) {
            Text(text = title,Modifier, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Text(text = details)
            Row(Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.SpaceBetween) {
                Text(text = "$${finalPriceOfOneProduct.value}")
                Row() {
                    CircleButton(source= R.drawable.ic_baseline_add_24, Color.White ){
                        if (numberOfProduct.value>1){
                            numberOfProduct.value++
                        }
                    }
                    Text(text = "${numberOfProduct.value}")
                    CircleButton(source= R.drawable.ic_baseline_horizontal_rule_24, Color.White ){
                        if (numberOfProduct.value<20){
                            numberOfProduct.value--
                        }
                    }
                }
            }
        }

    }

}