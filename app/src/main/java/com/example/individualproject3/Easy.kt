package com.example.individualproject3

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
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
fun Easy(navController: NavHostController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF25273E))
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Button(
            onClick = { navController.navigate("street") },
            modifier = Modifier
                .padding(top = 250.dp)
                .width(300.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEE3A57)),
            shape = RoundedCornerShape(16.dp)
        ) {
            Text(
                text = "Street Game",
                color = Color.White,
                fontSize = 18.sp
            )
        }

        Button(
            onClick = { /* Handle Match Game Button Click */ },
            modifier = Modifier
                .padding(top = 50.dp)
                .width(300.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEE3A57)),
            shape = RoundedCornerShape(16.dp)
        ) {
            Text(
                text = "Match Game",
                color = Color.White,
                fontSize = 18.sp
            )
        }

        Button(
            onClick = { /* Handle Quiz Game Button Click */ },
            modifier = Modifier
                .padding(top = 50.dp)
                .width(300.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEE3A57)),
            shape = RoundedCornerShape(16.dp)
        ) {
            Text(
                text = "Quiz Game",
                color = Color.White,
                fontSize = 18.sp
            )
        }
    }

}