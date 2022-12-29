package com.example.shopapp.screens.cart.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.shopapp.R
import com.example.shopapp.component.CostumeButton
import com.example.shopapp.screens.cart.CartViewModel
import com.example.shopapp.screens.home.components.ProductBox
import com.example.shopapp.util.AppColors
import kotlin.math.roundToInt




@Composable
fun CartSection(
    navController: NavController,
    viewModel: CartViewModel
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.background(AppColors.mBackgroundColor)
    ) {

        Column(modifier = Modifier
            .background(Color.Transparent)
            ){
            PromoCodeTextField(viewModel)
            Spacer(modifier = Modifier.height(20.dp))

            Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
                TotalBill(viewModel,viewModel.subTotal.value,4.99,0.00)
                Spacer(modifier = Modifier.height(20.dp))
                CostumeButton(color = Color.Black, modifier = Modifier, text = "Procced To Checkout", horiantalPadding = 40.dp, verticallPadding = 10.dp, onClickListner = {})
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
    }
}

@Composable
fun CartProducts(viewModel: CartViewModel,navController:NavController) {
    val productToBuy = viewModel.getCartItems()?.toMutableList() //Important!




    LazyColumn(modifier = Modifier.height(300.dp), content = {
        viewModel.getCartItems()?.let {
            if (productToBuy != null) {
                items(productToBuy.size) { i ->
                    val productIndex = remember { mutableStateOf(i) }

                    val productData = try {
                        productToBuy.get(productIndex.value)
                    } catch (ex: Exception) { null }

                    if (productData != null) {
                        ProductToBuy(viewModel =viewModel, title = productData.products[1].quantity.toString(),
                            details =productData.products.toString(), Price = productData.userId.toDouble() )
                    }
                }
            }
        }
    })


}

@Composable
fun TotalBill(
    viewModel: CartViewModel,
    subTotal: Double,
    shipping:Double,
    discount:Double,
) {

    val bogTotal: Double =((subTotal+shipping-discount) * 100.0).roundToInt() / 100.0

    BillItem(billItemName = "Subtotal",viewModel.subTotal.value)
    BillItem(billItemName = "Shipping",shipping)
    if (viewModel.PromoCodeValidation.value){
        BillItem(billItemName = "Discount",-discount)
    }
    BillItem(billItemName = "bog Total",bogTotal)
}

@Composable
fun BillItem(
    billItemName:String,
    subTotal:Double
) {
    Column() {
        Row(horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp)) {

            Text(text = billItemName, fontSize = 15.sp, fontWeight = FontWeight.ExtraBold)
            Text(buildAnnotatedString {
                withStyle(style = SpanStyle(color = Color.Black,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                ))
                {
                    append("$$subTotal")
                }
                Spacer(modifier = Modifier.width(5.dp))
                withStyle(style = SpanStyle(color = Color.Gray,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Light
                )){
                    append("USD")
                }
            })
        }

        Divider(color = Color.White, modifier = Modifier.padding(vertical = 2.dp))
    }
}

@Composable
fun PromoCodeTextField(
    viewModel: CartViewModel,
    modifier: Modifier = Modifier,
    hint: String = "",
    onSearch: (String) -> Unit = {}
) {
    var text by remember {
        mutableStateOf("")
    }
//    var isHintDisplayed by remember {
//        mutableStateOf(hint != "")
//    }
    Box(modifier = modifier) {
        BasicTextField(
            value = text,
            onValueChange = {
                text = it
                onSearch(it)
            },
            maxLines = 1,
            singleLine = true,
            textStyle = TextStyle(color = Color.Black),
            modifier = Modifier
                .fillMaxWidth()
                .shadow(2.dp, RoundedCornerShape(10.dp))
                .background(Color.White, RoundedCornerShape(10.dp))
                .padding(vertical = 25.dp, horizontal = 10.dp)
                .onFocusChanged {
//                    isHintDisplayed = it != FocusStateImpl.Active && text.isNotEmpty()
                }
        )
        promobutton(text, viewModel)
//        if(isHintDisplayed) {
//            Text(
//                text = hint,
//                color = Color.LightGray,
//                modifier = Modifier
//                    .padding(horizontal = 20.dp,
//                        vertical = 12.dp)
//            )
//        }
    }
}

@Composable
fun promobutton(
    text:String,
    viewModel: CartViewModel
){

        Row(horizontalArrangement = Arrangement.End,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Transparent)
                .padding(top = 10.dp, end = 10.dp)) {
            CostumeButton(color = Color.Black,
                modifier=Modifier,
                text = "Apply",
                horiantalPadding = 12.dp,
                verticallPadding = 2.dp,
                onClickListner = {
                    if (text =="PROMOCODE"){
                        viewModel.PromoCodeValidation.value = true
                    }
                })
        }



}