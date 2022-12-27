package com.example.shopapp.screens.home.components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.shopapp.R
import com.example.shopapp.Screens


//@Preview
@Composable
fun ProductBox(
    navController: NavController,
    id:Int,
    image:Int,
    title:String,
    details:String,
    price:Float,
){
    Box(modifier = Modifier
        .padding(15.dp)

        .clickable {
            navController.navigate(Screens.Product.withArgs(id))
        }) {

        Column(modifier = Modifier
            .shadow(3.dp, RoundedCornerShape(30.dp))
            .background(Color.White, RoundedCornerShape(30.dp))
            .padding(20.dp)
        )
        {
            Box(modifier = Modifier){
                CanImage(Modifier.fillMaxWidth(), image = image, width = 200.dp, height = 200.dp)
            }
            Text(text = title, fontWeight = FontWeight.Bold)
            Text(text = details)
            Row(modifier = Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.SpaceBetween) {
                Text(text = "$$price")
                CircleButton(source=R.drawable.ic_baseline_add_24,Color.White)
            }
        }
    }
}




@Composable
fun CanImage(
    modifier: Modifier,
    image:Int,
    width:Dp,
    height:Dp

) {
    val image= painterResource(id = image)
    Image(painter = image,contentDescription = "Image",
        modifier = Modifier
            .width(width)
            .height(height),
        contentScale = ContentScale.Crop,
    )

}