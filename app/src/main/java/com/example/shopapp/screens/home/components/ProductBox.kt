package com.example.shopapp.screens.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.shopapp.R


@Preview
@Composable
fun ProductBox(){
    Column(modifier = Modifier
        .padding(20.dp)
        .shadow(4.dp, RoundedCornerShape(15.dp))
        .background(Color.White, RoundedCornerShape(15.dp))
    )
    {
        CanImage(Modifier.fillMaxWidth())
        Text(text = "Can Mockup", fontWeight = FontWeight.Bold)
        Text(text = "Details about the Mockup of the Can")
        Row() {
            Text(text = "$9.99")
            RoundedCornerShape(10.dp)
        }
    }
}


@Composable
fun CanImage(modifier: Modifier) {
    val image= painterResource(id = R.drawable.img_1)
    Image(painter = image,contentDescription = "",
        modifier = Modifier
            .width(200.dp)
            .height(200.dp),
        contentScale = ContentScale.Crop,
    )

}