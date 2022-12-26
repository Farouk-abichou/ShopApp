package com.example.shopapp.component

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun BlackButton(
    text:String="Cart",
    cornerSize: Dp =10.dp
){
    Button(onClick = {
        
    },
        modifier = Modifier,
        shape = RoundedCornerShape(cornerSize),
        colors = ButtonDefaults.buttonColors(Color.Black),
    ){
        Text(text = text, color = Color.White)
    }

}