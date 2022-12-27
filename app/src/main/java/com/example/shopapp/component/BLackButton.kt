package com.example.shopapp.component

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shopapp.R

@Composable
fun BlackButton(
    text:String,
    cornerSize: Dp =22.dp
){
    Button(onClick = {
        
    },
        modifier = Modifier,
        shape = RoundedCornerShape(cornerSize),
        colors = ButtonDefaults.buttonColors(Color.Black),
    ){
        Text(text = text,Modifier.padding(10.dp), color = Color.White, fontSize = 18.sp, fontFamily = FontFamily( Font(
            R.font.bergentext_bold)))
    }

}