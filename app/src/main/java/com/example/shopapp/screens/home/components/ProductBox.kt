package com.example.shopapp.screens.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.shopapp.R


//@Preview
@Composable
fun ProductBox(
//    image:String,
    title:String,
    details:String,
    price:Float,
){
    Box(modifier = Modifier.padding(20.dp)) {

        Column(modifier = Modifier
            .shadow(4.dp, RoundedCornerShape(15.dp))
            .background(Color.White, RoundedCornerShape(15.dp))
            .padding(20.dp)
        )
        {
            CanImage(Modifier.fillMaxWidth(), image = R.drawable.img_1, width = 200.dp, height = 200.dp)
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
    Image(painter = image,contentDescription = "",
        modifier = Modifier
            .width(width)
            .height(height),
        contentScale = ContentScale.Crop,
    )

}