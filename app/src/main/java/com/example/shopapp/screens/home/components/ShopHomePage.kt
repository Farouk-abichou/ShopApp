package com.example.shopapp.screens.home.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
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
import androidx.compose.ui.unit.Dp
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
    viewModel: ShopHomeViewModel){
    Box(modifier = Modifier){
        Column() {
            Row(
                modifier = Modifier

            ) {
                SearchBar(
                    modifier = Modifier,
                    width = 265.dp
                ) {
//                    viewModel.searchPokemonList(it)
                }
                Spacer(modifier = Modifier.width(13.dp))
                Box(

                    modifier = Modifier

                        .size(50.dp)
                        .shadow(5.dp, RoundedCornerShape(10.dp))
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color.White)
                ){
                    Column(verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .fillMaxSize()
                            .clickable {
                                viewModel.showCategories.value = !viewModel.showCategories.value
                            }) {
                        Icon(
                            painter = painterResource(R.drawable.ic_baseline_checklist_rtl_24),
                            contentDescription = "Add to Card",
                            modifier = Modifier
                                .padding(1.dp)
                                .size(30.dp)
                        )
                    }

                }
            }
            Spacer(modifier = Modifier.height(20.dp))

            if (viewModel.showCategories.value){
                CategoriesSection(viewModel.categories,viewModel)
            }

            Spacer(modifier = Modifier.height(10.dp))


        }
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProductsGrid(
    viewModel: ShopHomeViewModel,
    navController:NavController
){
    Box(modifier = Modifier) {
        if (viewModel.productData.value.loading == true) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                CircularProgressIndicator(modifier = Modifier, color = AppColors.mBlack)
            }
        } else {
            val product =viewModel.getProducts()?.toMutableList() //Important!

            if (product != null) {

                LazyVerticalStaggeredGrid(columns = StaggeredGridCells.Fixed(2), content = {
                    item { Text(
                        text = "Found \r\n${viewModel.getProducts()?.size} Results",
                        modifier = Modifier.padding(start = 18.dp, bottom = 15.dp),
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 28.sp
                    ) }
                    items(product.size) { i ->

                        val productIndex = remember { mutableStateOf(i) }

                        val productData = try {
                            product[productIndex.value]
                        } catch (ex: Exception) {
                            null
                        }

                        if (productData != null) {
                            ProductBox(
                                navController,
                                id = productData.id,
                                image = productData.image,
                                title = productData.title,
                                details = productData.category,
                                price = productData.price,
                            )
                            Spacer(modifier = Modifier.height(25.dp))
                        }
                    }
                })
        }
        viewModel.productData.value.loading =false
        }
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
            }
            Spacer(modifier = Modifier.width(15.dp))
        }
    })
    Spacer(modifier = Modifier.height(8.dp))

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
    width: Dp,
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
                .width(width)
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


