package com.example.prosync.Screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Login(navController: NavHostController) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("ProSync") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF1976D2),
                    titleContentColor = Color.White
                )
            )
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(20.dp)
        ) {

            Spacer(modifier = Modifier.height(30.dp))

            Text(
                "Login",
                style = MaterialTheme.typography.headlineSmall.copy(
                    color = Color(0xFF1976D2),
                    fontWeight = FontWeight.Bold
                )
            )

            Text(
                "Please enter your email and password to continue",
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = Color(0xFF1976D2)
                )
            )

            Spacer(modifier = Modifier.height(30.dp))

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor =  Color(0xFF1976D2),
                    unfocusedBorderColor = Color(0xFF1976D2).copy(alpha = 0.6f),
                    focusedLabelColor = Color(0xFF1976D2),
                    unfocusedLabelColor = Color(0xFF1976D2),
                    cursorColor = Color(0xFF1976D2),
                    focusedTextColor = Color(0xFF1976D2),
                    unfocusedTextColor = Color(0xFF1976D2)
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor =  Color(0xFF1976D2),
                    unfocusedBorderColor = Color(0xFF1976D2).copy(alpha = 0.6f),
                    focusedLabelColor = Color(0xFF1976D2),
                    unfocusedLabelColor = Color(0xFF1976D2),
                    cursorColor = Color(0xFF1976D2),
                    focusedTextColor = Color(0xFF1976D2),
                    unfocusedTextColor = Color(0xFF1976D2)
                )
            )

            Spacer(modifier = Modifier.height(25.dp))

            Button(
                onClick = { navController.navigate("OnboardingScreen") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF1976D2),
                    contentColor = Color(0xFF1976D2)
                )
            ) {
                Text("Login",color=Color.White)
            }
            Spacer(modifier = Modifier.height(25.dp))
            Text("Don't have a Account? Create one.",
                Modifier.clickable{navController.navigate("Registration")})
        }
    }
}

