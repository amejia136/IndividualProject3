package com.example.individualproject3

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.compose.ui.Modifier




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginPage(navController: NavHostController) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }


    //UI Design *********************************************************************

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF25273E))
            .padding(horizontal = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text = "Log In",
            color = Color.White,
            fontSize = 40.sp,
            fontFamily = FontFamily.SansSerif,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(top = 100.dp)
        )
        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text(text = "Username", color = Color(0xFF858293)) },
            modifier = Modifier
                .padding(top = 70.dp)
                .width(300.dp),
            singleLine = true,
            textStyle = TextStyle(color = Color.White, fontSize = 18.sp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xFFEE3A57),
                unfocusedBorderColor = Color(0xFFEE3A57),
                cursorColor = Color.White,
                focusedLabelColor = Color(0xFFEE3A57),
                unfocusedLabelColor = Color(0xFF858293)
            )
        )

        OutlinedTextField(
            value = password,
            onValueChange = { password = it},
            label = { Text(text = "Password", color = Color(0xFF858293)) },
            modifier = Modifier
                .padding(top = 30.dp)
                .width(300.dp),
            singleLine = true,
            visualTransformation = PasswordVisualTransformation(),
            textStyle = TextStyle(color = Color.White, fontSize = 18.sp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xFFEE3A57),
                unfocusedBorderColor = Color(0xFFEE3A57),
                cursorColor = Color.White,
                focusedLabelColor = Color(0xFFEE3A57),
                unfocusedLabelColor = Color(0xFF858293)
            )
        )

        Button(
            onClick = { navController.navigate("mainpage") },
            modifier = Modifier
                .padding(top = 50.dp)
                .width(300.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEE3A57))
        ) {
            Text(
                text = "Log In",
                color = Color.White,
                fontSize = 18.sp
            )
        }

        Button(
            onClick = { navController.navigate("registration") },
            modifier = Modifier
                .padding(top = 50.dp)
                .width(300.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEE3A57))
        ) {
            Text(
                text = "Sign Up",
                color = Color.White,
                fontSize = 18.sp
            )
        }


    } //End of Class


}