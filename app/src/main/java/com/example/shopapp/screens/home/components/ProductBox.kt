package com.example.shopapp.screens.home.components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.shopapp.R
import com.example.shopapp.Screens
import com.example.shopapp.screens.home.ShopHomeViewModel


//@Preview
@Composable
fun ProductBox(
    viewModel: ShopHomeViewModel,
    navController: NavController,
    id:Int,
    image:String,
    title:String,
    category:String,
    price:Float,
){
    Box(modifier = Modifier
        .padding(horizontal = 15.dp, vertical = 0.dp)

        .clickable {
            navController.navigate(Screens.Product.withArgs(id))
        }) {

        Column(modifier = Modifier
            .shadow(3.dp, RoundedCornerShape(25.dp))
            .background(Color.White, RoundedCornerShape(25.dp))
            .padding(20.dp)
        )
        {
            Box(modifier = Modifier){
                ProductImage(Modifier.fillMaxWidth(), image = image, width = 200.dp, height = 200.dp)
            }
            Text(text = title, fontWeight = FontWeight.Bold)
            Text(text = category)
            Row(modifier = Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.SpaceBetween) {
                Text(text = "$$price")
                CircleButton(modifier = Modifier.clickable {
                    viewModel.addCartProduct(id = id,
                        title=title,
                        price = price,
                        category = category,
                        image = image,
                        )
                },
                    source=R.drawable.ic_baseline_add_24,
                    Color.White,
                )
            }
        }
    }
}




@Composable
fun ProductImage(
    modifier: Modifier,
    image: String,
    width:Dp,
    height:Dp

) {
    AsyncImage(
        model = image,
        contentDescription = null,
        modifier = modifier
            .width(width)
            .height(height),
        contentScale = ContentScale.Fit,
    )

}