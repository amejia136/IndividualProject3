package com.example.individualproject3

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
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
import androidx.compose.ui.unit.Dp
import kotlinx.coroutines.delay
import kotlin.random.Random

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StreetGamePage(navController: NavHostController) {

    var characterPosition by remember { mutableStateOf(0.dp) }
    var isGameOver by remember { mutableStateOf(false) }
    val cars = remember { mutableStateListOf<Car>() }

    LaunchedEffect(Unit) {
        while (!isGameOver) {
            delay(2000L)
            cars.add(Car(yPosition = Random.nextInt(-300, 300).dp))
        }
    }

    LaunchedEffect(Unit) {
        while (!isGameOver) {
            delay(16L)
            cars.forEach { car ->
                car.xPosition -= 5.dp
                // Check for collision
                if (car.collidesWith(characterPosition)) {
                    isGameOver = true
                }
            }

            cars.removeAll { it.xPosition < -400.dp }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF25273E)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Black),
            contentAlignment = Alignment.Center
        ) {

            cars.forEach { car ->

                val animatedXPosition by animateDpAsState(
                    targetValue = car.xPosition,
                    animationSpec = tween(
                        durationMillis = 2000,
                        easing = LinearEasing
                    )
                )

                Box(
                    modifier = Modifier
                        .offset(x = animatedXPosition, y = car.yPosition)
                        .size(20.dp)
                        .background(Color.Yellow, CircleShape)
                )
            }

            if (!isGameOver) {
                Box(
                    modifier = Modifier
                        .offset(y = characterPosition)
                        .size(50.dp)
                        .background(Color.Red, CircleShape)
                )
            } else {
                Text(
                    text = "Game Over",
                    color = Color.White,
                    style = MaterialTheme.typography.headlineMedium
                )
            }
        }

        if (!isGameOver) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {

                Button(
                    onClick = {
                        if (characterPosition > -300.dp) characterPosition -= 50.dp
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEE3A57)),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Text(text = "Up", color = Color.White)
                }

                Button(
                    onClick = {
                        if (characterPosition < 300.dp) characterPosition += 50.dp
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEE3A57)),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Text(text = "Down", color = Color.White)
                }
            }

        } else {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {

                Button(
                    onClick = {

                        isGameOver = false
                        characterPosition = 0.dp
                        cars.clear()
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50)),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Text(text = "Start Over", color = Color.White)
                }


                Button(
                    onClick = {
                        navController.popBackStack()
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF44336)),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Text(text = "Exit", color = Color.White)
                }
            }
        }
    }
}

data class Car(
    var xPosition: Dp = 400.dp,
    val yPosition: Dp
) {

    fun collidesWith(characterY: Dp): Boolean {
        val carCenter = yPosition.value + 10
        val characterCenter = characterY.value + 25
        return xPosition.value < 50 &&
                Math.abs(carCenter - characterCenter) < 35
    }
}
