package com.example.shopapp.screens.product.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.shopapp.R
import com.example.shopapp.component.BlackButton
import com.example.shopapp.screens.home.components.CanImage
import com.example.shopapp.screens.product.ProductViewModel
import com.example.shopapp.util.AppColors
import kotlin.math.roundToInt
import kotlin.random.Random.Default.nextFloat


@Composable
fun ProductPage(
    navController: NavController,
    viewModel: ProductViewModel
) {
    val product=viewModel.PrductById.value
    Scaffold(

    ) {
                Box(
                    modifier = Modifier
                        .background(AppColors.mBackgroundColor)
                        .fillMaxWidth()
                ) {
                    TopAppBar(
                        Modifier
                            .height(120.dp)
                            .padding(top = 20.dp),
                        backgroundColor = Color.Transparent,
                        elevation = 0.dp,
                    ) {
                        Column(modifier = Modifier) {
                            Row(
                                Modifier
                                    .fillMaxWidth()
                                    .padding(20.dp),
                                horizontalArrangement = Arrangement.SpaceBetween
                            )
                            {
                                Icon(painter = painterResource(R.drawable.ic_baseline_arrow_back_ios_24),
                                    contentDescription = "Back",
                                    modifier = Modifier
                                        .align(Alignment.CenterVertically)
                                        .clickable {
                                            navController.popBackStack()
                                        }
                                )



                                Icon(
                                    painter = painterResource(R.drawable.ic_baseline_cruelty_free_24),
                                    contentDescription = "Cute Bunny",
                                    modifier = Modifier
                                        .align(Alignment.CenterVertically)
                                        .clickable {
//                            navController.popBackStack()
                                        },
                                )
                            }
                        }
                    }
                    Column(verticalArrangement = Arrangement.Center,modifier = Modifier.fillMaxSize()) {
                        CanImage(modifier = Modifier, image = R.drawable.drink_can, width = 400.dp, height =500.dp)
                        Spacer(modifier = Modifier.height(100.dp))
                    }

                    Column(verticalArrangement = Arrangement.Bottom,modifier = Modifier.fillMaxSize()) {

                    BottomProductCard(modifier = Modifier.fillMaxSize(),
                    productName = product.title,
                    productDetails = product.category,
                    productReview = product.rating.rate.toString(),
                    productPrice = product.price)
                    }
                }
    }
}



@Composable
fun BottomProductCard(
    modifier: Modifier,
    productName:String,
    productDetails:String,
    productReview:String,
    productPrice: Float
){
    val quantity: MutableState<Int> = remember {
        mutableStateOf(1)
    }



    val finalQuantity: Double =(quantity.value * productPrice * 100.0).roundToInt() / 100.0

    Card(modifier = Modifier
        .height(200.dp),
        shape = RoundedCornerShape(
        topStart = 40.dp,
        topEnd = 40.dp,
        bottomStart = 0.dp,
        bottomEnd = 0.dp),
        backgroundColor = Color.White,
        elevation = 15.dp
    ) {
       Column(verticalArrangement = Arrangement.SpaceBetween,
           modifier = Modifier
               .fillMaxSize()
               .padding(
                   top = 30.dp,
                   start = 30.dp,
                   end = 30.dp,
                   bottom = 30.dp
               )) {

           Column(modifier = Modifier) {
               Row(horizontalArrangement = Arrangement.SpaceBetween,
                   modifier = Modifier.fillMaxWidth()) {
                   Text(text = productName,
                       fontSize = 25.sp,
                       fontWeight = FontWeight.ExtraBold,
                       fontFamily = FontFamily(
                           Font(R.font.bergentext_bold)
                       )
                       )
//                   StarsReview()
               }
               Row(horizontalArrangement = Arrangement.SpaceBetween,
                   modifier = Modifier.fillMaxWidth()) {
                   Text(text = productDetails,
                       fontSize = 12.sp,
                       fontWeight = FontWeight.Normal,
                       )
                   Text(text = productReview,
                       fontSize = 10.sp,
                       fontWeight = FontWeight.Normal,)
               }
           }
           Row(horizontalArrangement = Arrangement.SpaceBetween,
               verticalAlignment = Alignment.CenterVertically,
               modifier = Modifier.fillMaxWidth()) {
               Text(text = "$${ finalQuantity}",
                   fontSize = 27.sp,
                   fontWeight = FontWeight.ExtraBold,
                   fontFamily = FontFamily.Default)
               Spacer(modifier = Modifier.width(20.dp))

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

                   Text(text = "${quantity.value}", modifier = Modifier.padding(horizontal = 15.dp), fontFamily = FontFamily(Font(
                       R.font.bergentext_regular)))

                   Text(text = " +", modifier = Modifier.clickable {
                       if (quantity.value<20){
                           quantity.value++
                       }
                   })


               }
               BlackButton(text = "Cart")
           }
           
       } 
    }
}

@Composable
fun StarsReview() {
    TODO("Not yet implemented")
}
