package com.example.shopapp.screens.home.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shopapp.R
import com.example.shopapp.util.AppColors


@Preview(showBackground = true)
@Composable
fun ShopHomePage(){
    Scaffold(modifier = Modifier
        .fillMaxSize()
        .background(color = AppColors.mBackgroundColor)) {

        Column {
            TopAppBar(
                Modifier.height(100.dp),
                backgroundColor = Color.Transparent,
                elevation = 0.dp,
            ) {
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
                            .align(CenterVertically)
                            .clickable {
//                            navController.popBackStack()
                            }
                    )

                    Text(
                        text = "Search Product",
                        modifier = Modifier.padding(horizontal = 20.dp),
                        fontFamily = FontFamily(
                            Font(
                                R.font.bergentext_semibold,
                                FontWeight.Normal
                            )
                        ),
                        fontSize = 18.sp
                    )

                    Icon(
                        painter = painterResource(R.drawable.ic_baseline_cruelty_free_24),
                        contentDescription = "Cute Bunny",
                        modifier = Modifier
                            .align(CenterVertically)
                            .clickable {
//                            navController.popBackStack()
                            },
                    )
                }


            }
            Row(Modifier.fillMaxWidth()){
                SearchBar()

            }
            Grid()
        }

    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Grid(){
    LazyVerticalGrid(cells = GridCells.Fixed(2), content = {
        items (20){ i ->
            ProductBox()

        }
    })

}


@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    hint: String = "",
    onSearch: (String) -> Unit = {},
) {
    var text by remember {
        mutableStateOf("")
    }
    var isHintDisplayed by remember {
        mutableStateOf(hint != "")
    }

    Box(modifier = modifier.padding(5.dp)) {
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
                .fillMaxWidth(0.8f)
                .shadow(4.dp, RoundedCornerShape(15.dp))
                .background(Color.White, RoundedCornerShape(15.dp))
                .padding(horizontal = 20.dp, vertical = 10.dp)
                .onFocusChanged {
//                    isHintDisplayed = it != FocusStateImpl.Active && text.isNotEmpty()
                }
        )
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