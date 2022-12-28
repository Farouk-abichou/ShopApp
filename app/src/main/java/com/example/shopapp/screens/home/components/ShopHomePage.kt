package com.example.shopapp.screens.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.shopapp.R
import com.example.shopapp.screens.home.ShopHomeViewModel
import com.example.shopapp.util.AppColors


@Composable
fun ShopHomePage(
    navController: NavController,
    viewModel: ShopHomeViewModel){
    val product =viewModel.productData.value.data?.toMutableList() //Important!
    Box(modifier = Modifier.fillMaxSize()){
        Column {

            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 0.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                SearchBar(
                    hint = "Search...",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
//                    viewModel.searchPokemonList(it)
                }
                Box(
                    modifier = Modifier
                        .size(50.dp)
                        .padding(3.dp)
                        .shadow(5.dp, RoundedCornerShape(10.dp))
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color.White)
                )

            }

//            ProductToBuy()


            Text(
                text = "Found ${viewModel.productData.value.data?.size} Result",
                modifier = Modifier.padding(start = 30.dp, bottom = 10.dp),
                fontWeight = FontWeight.ExtraBold,
                fontSize = 30.sp
            )


            Box(modifier = Modifier.padding(12.dp)) {
                if (viewModel.productData.value.loading == true) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        CircularProgressIndicator(modifier = Modifier, color = AppColors.mDarkPurple)
                    }

                } else {

                    if (product != null) {
                        LazyVerticalGrid(columns = GridCells.Fixed(2), content = {
                            viewModel.productData.value.data?.let {
                                items(it.size) { i ->
                                    val productIndex = remember {
                                        mutableStateOf(i)
                                    }

                                    val productData = try {
                                        product[productIndex.value]
                                    } catch (ex: Exception) {
                                        null
                                    }

                                    if (productData != null) {


                                        ProductBox(
                                            navController,
                                            id = productData.id,
                                            image = R.drawable.drink_can,
                                            title = productData.title,
                                            details = productData.category,
                                            price = productData.price,
                                        )
                                    }
                                }
                            }
                        })
                    }
                }

            }

        }
    }
}


@Composable
fun TopAppBar(

    modifier: Modifier
)
{

    TopAppBar(
        modifier
            .height(120.dp)
            .padding(top = 20.dp),
        backgroundColor = Color.Transparent,
        elevation = 0.dp,
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 28.dp, vertical = 20.dp),
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
                modifier = Modifier,
                fontFamily = FontFamily(
                    Font(
                        R.font.bergentext_bold,
                        FontWeight.ExtraBold
                    )
                ),
                fontSize = 20.sp
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


}




@Composable
fun SearchBar(
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

