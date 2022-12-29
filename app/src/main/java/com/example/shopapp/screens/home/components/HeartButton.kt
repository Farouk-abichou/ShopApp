package com.example.shopapp.screens.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp


@Composable
fun CircleButton(
    modifier: Modifier,
    source: Int,
    backgroundColor: Color,
    onClicked: (Int) -> Unit = {}
    ){
    Box(
        modifier = Modifier
            .shadow(1.dp, CircleShape)
            .border(1.dp,Color.Black,CircleShape)
            .background(backgroundColor)
            .clickable { onClicked }
    ){
        Icon(
            painter = painterResource(source),
            contentDescription = "Add to Card",
            modifier = Modifier
        )
    }

}