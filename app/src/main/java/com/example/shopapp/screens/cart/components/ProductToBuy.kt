package com.example.shopapp.screens.cart.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shopapp.R
import com.example.shopapp.screens.cart.CartViewModel
import com.example.shopapp.screens.home.components.CanImage
import com.example.shopapp.screens.home.components.CircleButton
import com.example.shopapp.screens.product.ProductViewModel
import kotlin.math.roundToInt


@Composable
fun ProductToBuy(
    viewModel: CartViewModel,
    title:String="Facial Cleanser",
    details:String="Size 7.60 fil oz /225ml",
    Price:Double=19.98,
){

    val quantity: MutableState<Int> = remember {
        mutableStateOf(1)
    }
    val finalQuantity: Double =(quantity.value * Price * 100.0).roundToInt() / 100.0

    viewModel.subTotal.value = finalQuantity


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
            CanImage(modifier = Modifier,
                image = R.drawable.ic_baseline_add_24,
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
                Text(text = "$${finalQuantity}",
                    modifier = Modifier,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.ExtraBold
                )
                Row(modifier = Modifier
                    .border(1.dp, Color.Gray, RoundedCornerShape(20.dp))
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color.White)
                    .padding(horizontal = 20.dp, vertical = 7.dp)) {
                    Text(text = "- ", modifier = Modifier.clickable {
                        if (quantity.value>1){
                            quantity.value--
                        }
                    })

                    Text(text = "${quantity.value}", modifier = Modifier.padding(horizontal = 15.dp), fontFamily = FontFamily(
                        Font(
                        R.font.bergentext_regular)
                    )
                    )

                    Text(text = " +", modifier = Modifier.clickable {
                        if (quantity.value<20){
                            quantity.value++
                        }
                    })


                }
//                    CircleButton(source= R.drawable.ic_baseline_add_24, Color.White ){
////                        if (viewModel.reputationOfProduct.value<1){
//                            viewModel.reputationOfProduct.value--
////                        }
//                    }
            }
        }

    }

}