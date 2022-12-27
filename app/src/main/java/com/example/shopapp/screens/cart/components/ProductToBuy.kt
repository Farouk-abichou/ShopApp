package com.example.shopapp.screens.cart.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
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
    title:String="Facial Cleanser",
    details:String="Size 7.60 fil oz /225ml",
    Price:Double=19.98,

){
    val finalPriceOfOneProduct:MutableState<Double> = remember {
        mutableStateOf(Price)
    }

    val numberOfProduct:MutableState<Int> = remember {
        mutableStateOf(1)
    }

    Row(modifier = Modifier
        .fillMaxWidth()
        .background(Color.Transparent)
        .padding(
            horizontal = 20.dp,
            vertical = 10.dp
        )) {
        Box(
            modifier = Modifier
                .padding(3.dp)
                .shadow(4.dp, RoundedCornerShape(10.dp))
                .clip(RoundedCornerShape(10.dp))
                .background(Color.White)
        ){
            CanImage(modifier = Modifier,
                image = R.drawable.drink_can,
                100.dp,
                100.dp)
        }
        Spacer(modifier = Modifier.width(10.dp))
        Column( Modifier.height(100.dp),
            verticalArrangement = Arrangement.SpaceEvenly) {
            Text(text = title,
                Modifier,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold)
            Text(text = details, modifier = Modifier,
                color = Color.Gray,
            fontSize = 12.sp)
            Spacer(modifier = Modifier.width(20.dp))
            Row(Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween) {
                Text(text = "$${finalPriceOfOneProduct.value}",
                    modifier = Modifier,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.ExtraBold
                )
                Row(modifier = Modifier) {
                    CircleButton(source= R.drawable.ic_baseline_add_24, Color.Transparent ){
                        if (numberOfProduct.value>1){
                            numberOfProduct.value++
                        }
                    }
                    Text(text = "${numberOfProduct.value}", modifier = Modifier.padding(horizontal = 5.dp))
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