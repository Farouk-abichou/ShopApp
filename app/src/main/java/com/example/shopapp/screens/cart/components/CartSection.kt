package com.example.shopapp.screens.cart.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.shopapp.component.BlackButton
import com.example.shopapp.screens.cart.CartViewModel
import com.example.shopapp.screens.home.components.TopAppBar
import com.example.shopapp.util.AppColors


@Composable
fun CartSection(
    navController: NavController,
    viewModel: CartViewModel
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.background(AppColors.mBackgroundColor)
    ) {
        TopAppBar(modifier = Modifier)
        Column(modifier = Modifier
            .background(Color.Transparent)
            .padding(horizontal = 30.dp)){
            CartProducts()
            PromoCodeTextField()
            Spacer(modifier = Modifier.height(20.dp))

            Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
                TotalBill()
                Spacer(modifier = Modifier.height(20.dp))
                BlackButton(modifier = Modifier, text = "Procced To Checkout", horiantalPadding = 40.dp, verticallPadding = 10.dp)
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
    }
}

@Composable
fun CartProducts(/*viewModel: CartViewModel*/) {

    ProductToBuy()
    ProductToBuy()
    ProductToBuy()



//    LazyColumn(content = {
//        viewModel.data.value.data?.let {
//            items(it.size) { i ->
//
//            }
//        }
//    })
}

@Composable
fun TotalBill() {

    BillItem()
    BillItem()
    BillItem()
}
//@Preview(showBackground = true)
@Composable
fun BillItem(
    billItemName:String="Subtotal",
    subTotal:Double =45.99
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


//@Preview(showBackground = true)
@Composable
fun PromoCodeTextField(
    modifier: Modifier = Modifier,
    hint: String = "",
    onSearch: (String) -> Unit = {}
) {
    var text by remember {
        mutableStateOf("")
    }
    var isHintDisplayed by remember {
        mutableStateOf(hint != "")
    }

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
                .shadow(5.dp, RoundedCornerShape(10.dp))
                .background(Color.White, RoundedCornerShape(10.dp))
                .padding(horizontal = 20.dp, vertical = 12.dp)
                .onFocusChanged {
//                    isHintDisplayed = it != FocusStateImpl.Active && text.isNotEmpty()
                }
        ){
            Row(horizontalArrangement = Arrangement.End,modifier = Modifier.fillMaxWidth()) {
                BlackButton(modifier=Modifier,text = "Apply", horiantalPadding = 12.dp, verticallPadding = 2.dp)
            }
        }
        if(isHintDisplayed) {
            Text(
                text = hint,
                color = Color.LightGray,
                modifier = Modifier
                    .padding(horizontal = 20.dp, vertical = 12.dp)
            )
        }
    }
}