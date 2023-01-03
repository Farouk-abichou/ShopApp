package com.example.shopapp.screens.login.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shopapp.z_component.CostumeButton
import com.example.shopapp.util.AppColors

@Preview(showBackground = true)
@Composable
fun LoginPage(

){
    Box(modifier = Modifier){
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom, modifier = Modifier.fillMaxSize()) {
            Text(
                text = "Log in",
                modifier = Modifier,
                fontWeight = FontWeight.Bold,
                fontSize = 28.sp
            )
            Spacer(modifier = Modifier.height(40.dp))
            CustomTextField(icon=com.example.shopapp.R.drawable.ic_baseline_person_outline_24)
            Spacer(modifier = Modifier.height(25.dp))
            CustomTextField(icon=com.example.shopapp.R.drawable.ic_baseline_password_24)
            Spacer(modifier = Modifier.height(25.dp))
            CostumeButton(
                modifier = Modifier,
                color = AppColors.mBlack,
                horiantalPadding = 40.dp,
                verticallPadding = 5.dp,
                text = "Log in"
            ) {
                
            }
            Spacer(modifier = Modifier.height(200.dp))
            Row(horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(checked = false, onCheckedChange = {})
                    Text(text = "Remember me")
                }
                Text(text = "Forgot your password?  ")
            }
        }
    }
}



@Composable
fun CustomTextField(
    icon:Int,
) {
    var text by remember {
        mutableStateOf("")
    }
    Card(Modifier.fillMaxWidth(0.8f)
        .shadow(10.dp, RoundedCornerShape(10.dp)),
        shape = RoundedCornerShape(20.dp)
    ) {
        Row(
            Modifier
                .height(60.dp)
        ) {
            Icon(
                painter = painterResource(icon),
                contentDescription = "icon",
                modifier = Modifier.padding(18.dp).alpha(0.5f)
            )
            BasicTextField(
                value = text,
                onValueChange = { text = it },
                Modifier
                    .weight(1f)
                    .padding(vertical = 20.dp, horizontal = 10.dp)
            )
        }
    }
}