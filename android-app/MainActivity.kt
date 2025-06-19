package com.localchatapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.localchatapp.ui.theme.LocalChatAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LocalChatAppTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    LoginScreen()
                }
            }
        }
    }
}

@Composable
fun LoginScreen() {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isLoggedIn by remember { mutableStateOf(false) }
    var showModeSelection by remember { mutableStateOf(false) }

    if (isLoggedIn) {
        if (showModeSelection) {
            ModeSelectionScreen(onModeSelected = { mode ->
                // TODO: Navigate to chat screen with selected mode
            })
        } else {
            showModeSelection = true
        }
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Login", style = MaterialTheme.typography.h4)
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = username,
                onValueChange = { username = it },
                label = { Text("Username") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                modifier = Modifier.fillMaxWidth(),
                visualTransformation = PasswordVisualTransformation()
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {
                    // TODO: Implement login logic
                    isLoggedIn = true
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Login")
            }
            Spacer(modifier = Modifier.height(8.dp))
            TextButton(
                onClick = {
                    // TODO: Navigate to signup screen
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Create Account")
            }
        }
    }
}

@Composable
fun ModeSelectionScreen(onModeSelected: (String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Select Mode", style = MaterialTheme.typography.h4)
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { onModeSelected("local") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Local Mode (WiFi LAN)")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = { onModeSelected("online") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Online Mode (Public API)")
        }
    }
}
