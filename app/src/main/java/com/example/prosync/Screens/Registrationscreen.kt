package com.example.prosync.Screens

import androidx.compose.material3.Text
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Registration(navController1: NavHostController) {

    var name by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
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
                "Register",
                style = MaterialTheme.typography.headlineSmall.copy(
                    color = Color(0xFF1976D2),
                    fontWeight = FontWeight.Bold
                )
            )

            Text(
                "Create your account to get started",
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = Color(0xFF1976D2)
                )
            )

            Spacer(modifier = Modifier.height(30.dp))

            // Name
            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Name") },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color(0xFF1976D2),
                    unfocusedBorderColor = Color(0xFF1976D2).copy(alpha = 0.6f),
                    focusedLabelColor = Color(0xFF1976D2),
                    unfocusedLabelColor = Color(0xFF1976D2),
                    cursorColor = Color(0xFF1976D2),
                    focusedTextColor = Color(0xFF1976D2),
                    unfocusedTextColor = Color(0xFF1976D2)
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Phone
            OutlinedTextField(
                value = phone,
                onValueChange = { phone = it },
                label = { Text("Phone Number") },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color(0xFF1976D2),
                    unfocusedBorderColor = Color(0xFF1976D2).copy(alpha = 0.6f),
                    focusedLabelColor = Color(0xFF1976D2),
                    unfocusedLabelColor = Color(0xFF1976D2),
                    cursorColor = Color(0xFF1976D2),
                    focusedTextColor = Color(0xFF1976D2),
                    unfocusedTextColor = Color(0xFF1976D2)
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Email
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color(0xFF1976D2),
                    unfocusedBorderColor = Color(0xFF1976D2).copy(alpha = 0.6f),
                    focusedLabelColor = Color(0xFF1976D2),
                    unfocusedLabelColor = Color(0xFF1976D2),
                    cursorColor = Color(0xFF1976D2),
                    focusedTextColor = Color(0xFF1976D2),
                    unfocusedTextColor = Color(0xFF1976D2)
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Password
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color(0xFF1976D2),
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
                onClick = { /* register */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF1976D2)
                )
            ) {
                Text("Register", color = Color.White)
            }
        }
    }
}

