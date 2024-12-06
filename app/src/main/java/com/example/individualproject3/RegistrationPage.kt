package com.example.individualproject3

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TextFieldDefaults.outlinedTextFieldColors
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
import androidx.compose.ui.Modifier


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegistrationPage(navController: NavHostController) {
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF25273E))
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text = "Sign Up",
            color = Color.White,
            fontSize = 40.sp,
            fontFamily = FontFamily.SansSerif,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(top = 100.dp)
        )

        Row(
            modifier = Modifier
                .padding(top = 70.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            OutlinedTextField(
                value = firstName,
                onValueChange = {firstName = it},
                label = { Text(text = "First Name", color = Color(0xFF858293)) },
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp),
                singleLine = true,
                shape = RoundedCornerShape(40.dp),
                colors = outlinedTextFieldColors(
                    focusedBorderColor = Color(0xFFEE3A57),
                    unfocusedBorderColor = Color(0xFFEE3A57),
                )
            )

            OutlinedTextField(
                value = lastName,
                onValueChange = {lastName = it},
                label = { Text(text = "Last Name", color = Color(0xFF858293)) },
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 8.dp),
                singleLine = true,
                shape = RoundedCornerShape(40.dp),
                colors = outlinedTextFieldColors(
                    focusedBorderColor = Color(0xFFEE3A57),
                    unfocusedBorderColor = Color(0xFFEE3A57),
                )
            )
        }

        OutlinedTextField(
            value = email,
            onValueChange = {email = it},
            label = { Text(text = "Email", color = Color(0xFF858293)) },
            modifier = Modifier
                .padding(top = 30.dp)
                .width(300.dp),
            singleLine = true,
            shape = RoundedCornerShape(40.dp),
            colors = outlinedTextFieldColors(
                focusedBorderColor = Color(0xFFEE3A57),
                unfocusedBorderColor = Color(0xFFEE3A57),
            )
        )

        OutlinedTextField(
            value = password,
            onValueChange = {password = it},
            label = { Text(text = "Password", color = Color(0xFF858293)) },
            modifier = Modifier
                .padding(top = 30.dp)
                .width(300.dp),
            singleLine = true,
            shape = RoundedCornerShape(40.dp),
            visualTransformation = PasswordVisualTransformation(),
            colors = outlinedTextFieldColors(
                focusedBorderColor = Color(0xFFEE3A57),
                unfocusedBorderColor = Color(0xFFEE3A57),
            )
        )

        OutlinedTextField(
            value = confirmPassword,
            onValueChange = {confirmPassword = it},
            label = { Text(text = "Confirm Password", color = Color(0xFF858293)) },
            modifier = Modifier
                .padding(top = 30.dp)
                .width(300.dp),
            singleLine = true,
            shape = RoundedCornerShape(40.dp),
            colors = outlinedTextFieldColors(
                focusedBorderColor = Color(0xFFEE3A57),
                unfocusedBorderColor = Color(0xFFEE3A57),
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
                text = "Sign Up",
                color = Color.White,
                fontSize = 18.sp
            )
        }
    }

}//End of Class