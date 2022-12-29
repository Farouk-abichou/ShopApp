package com.example.shopapp.screens.home.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
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
import com.example.shopapp.Screens
import com.example.shopapp.component.CostumeButton
import com.example.shopapp.screens.home.ShopHomeViewModel
import com.example.shopapp.util.AppColors


@Composable
fun ShopHomePage(
    modifier: Modifier,
    navController: NavController,
    viewModel: ShopHomeViewModel){
    Box(modifier = Modifier){
        Column {
            Row(
                Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                SearchBar(
                    hint = "",
                    modifier = Modifier
                ) {
//                    viewModel.searchPokemonList(it)
                }
                Box(
                    modifier = Modifier
                        .size(5.dp)
                        .shadow(5.dp, RoundedCornerShape(10.dp))
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color.Black)
                )
            }
            Spacer(modifier = Modifier.height(20.dp))

            CategoriesSection(viewModel.categories.value,viewModel)

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Found ${viewModel.getProducts()?.size} Result",
                modifier = Modifier,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 30.sp
            )
        }
    }
}


@Composable
fun ProductsGrid(
    modifier: Modifier,
    viewModel: ShopHomeViewModel,
    navController:NavController
){
    Box(modifier = Modifier) {
//        if (viewModel.productData.value.loading == true) {
//            Row(
//                modifier = Modifier.fillMaxWidth(),
//                horizontalArrangement = Arrangement.Center
//            ) {
//                CircularProgressIndicator(modifier = Modifier, color = AppColors.mDarkPurple)
//            }
//        } else {
            val product =viewModel.getProducts()?.toMutableList() //Important!

            if (product != null) {
                LazyVerticalGrid(columns = GridCells.Fixed(2), content = {
                    items(product.size) { i ->
                        val productIndex = remember { mutableStateOf(i) }

                        val productData = try { product[productIndex.value] }
                        catch (ex: Exception) { null }

                        if (productData != null) {
                            ProductBox(
                                navController,
                                id = productData.id,
                                image = R.drawable.ic_baseline_add_24,
                                title = productData.title,
                                details = productData.category,
                                price = productData.price,
                            )
                        }
                    }
                })
            }
//        }
    }
}



@Composable
fun CategoriesSection(
    category:ArrayList<String>,
    viewModel: ShopHomeViewModel,


) {
    val clickedCategory:MutableState<String> = remember {
        mutableStateOf("")
    }
    LazyRow(content = {
        items(category.size){item ->
            CostumeButton(
                modifier = Modifier,
                color = AppColors.mBlack,
                horiantalPadding = 10.dp,
                verticallPadding = 2.dp,
                text = category[item]
            ){
                clickedCategory.value=category[item]
                if (clickedCategory.value != ""){
                    viewModel.categorySelected.value =clickedCategory.value
                }
                Log.d("aaaa", viewModel.getProducts().toString())
            }
            Spacer(modifier = Modifier.width(15.dp))
        }

    }
    )

}


@Composable
fun TopAppBar(

    navController: NavController,
    modifier: Modifier
)
{

    TopAppBar(
        modifier
            .height(90.dp),
        backgroundColor = Color.Transparent,
        elevation = 0.dp,
    ) {
        Row(
            Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        )
        {
            Icon(painter = painterResource(R.drawable.ic_baseline_arrow_back_ios_24),
                contentDescription = "Back",
                modifier = Modifier
                    .align(CenterVertically)
                    .clickable {
                            navController.popBackStack()
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
                painter = painterResource(R.drawable.ic_baseline_shopping_cart_24),
                contentDescription = "Cute Bunny",
                modifier = Modifier
                    .align(CenterVertically)
                    .clickable {
                            navController.navigate(Screens.Cart.route)
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
//    var isHintDisplayed by remember {
//        mutableStateOf(hint != "")
//    }

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
                .shadow(2.dp, RoundedCornerShape(10.dp))
                .background(Color.White, RoundedCornerShape(10.dp))
                .padding(vertical = 15.dp, horizontal = 10.dp)
                .onFocusChanged {
//                    isHintDisplayed = it != FocusStateImpl.Active && text.isNotEmpty()
                }
        )
//        if(isHintDisplayed) {
//            Text(
//                text = hint,
//                color = Color.LightGray,
//                modifier = Modifier
//                    .padding(horizontal = 20.dp, vertical = 12.dp)
//            )
//        }
    }
}

