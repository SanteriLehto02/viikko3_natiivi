package com.example.myapplication
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.ui.unit.dp
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.myapplication.ui.theme.MyApplicationTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                LoginForm()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginForm() {
    var username: String by remember { mutableStateOf("") }
    var password:String by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(top = 32.dp, start = 8.dp, end = 8.dp, bottom = 8.dp)) {
        Text(
            text = "Login",
            color = Color(0xFF6200EE),
            fontSize = 24.sp
        )

        OutlinedTextField(
            value = username,
            onValueChange = {username = it},
            label = { Text(text = "username")},
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color(0xFF6200EE), // Purple border color when focused
                unfocusedIndicatorColor = Color(0xFF6200EE) // Purple border color when not focused
            )
        )

        OutlinedTextField(
            value = password,
            onValueChange = {password = it},
            label = { Text(text = "password")},
            singleLine = true,
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color(0xFF6200EE), // Purple border color when focused
                unfocusedIndicatorColor = Color(0xFF6200EE) // Purple border color when not focused
            )
        )

        Button(
            onClick = { /* Handle button click */ },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .height(56.dp),
            shape = RectangleShape,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF6200EE),
                contentColor = Color.White
            )

        ) {
            Text("Submit")
        }

    }
}



