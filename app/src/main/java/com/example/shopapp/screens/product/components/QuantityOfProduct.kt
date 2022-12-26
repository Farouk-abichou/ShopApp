package com.example.shopapp.screens.product.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun QuantityOfProduct(){
    val quantity: MutableState<Int> = remember {
        mutableStateOf(1)
    }
    Row(modifier = Modifier
        .shadow(8.dp, RoundedCornerShape(20.dp))
        .clip(RoundedCornerShape(20.dp))
        .background(Color.White)
        .padding(horizontal = 20.dp, vertical = 5.dp)) {
        Text(text = " - ", modifier = Modifier.clickable {
            if (quantity.value>1){
                quantity.value--
            }
        })

        Text(text = "${quantity.value}", modifier = Modifier.padding(horizontal = 20.dp))

        Text(text = " + ", modifier = Modifier.clickable {
            if (quantity.value<20){
                quantity.value++
            }
        })


    }


}