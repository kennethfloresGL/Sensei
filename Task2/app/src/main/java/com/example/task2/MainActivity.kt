package com.example.task2

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.task2.ui.theme.Task2Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    viewModel: MainViewModel = hiltViewModel()

) {
    Task2Theme {
        val uiState by viewModel.uiState.collectAsState()

        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .background(colorResource(id = R.color.background))
        ) {
            Text(
                text = "facebook",
                modifier = Modifier
                    .padding(top = 200.dp),
                color = Color.White,
                fontSize = 50.sp,
                fontWeight = FontWeight.Bold
            )

            // Email or phone number
            TextField(
                value = uiState.emailOrPhoneNumber,
                onValueChange = { /*emailOrPhoneNumber = it*/ },
                label = { Text("Email or phone number") },
                modifier = Modifier
                    .padding(15.dp)
                    .fillMaxWidth()
                    .background(Color.White)
            )

            // Password
            TextField(
                value = uiState.password,
                onValueChange = { /*password = it */},
                label = { Text("Password") },
                modifier = Modifier
                    .padding(15.dp)
                    .fillMaxWidth()
                    .background(Color.White)
            )

            // Button
            Button(
                onClick = {
                    // Your login logic here
                },
                colors = ButtonDefaults.buttonColors(colorResource(R.color.purple_200)),
                modifier = Modifier
                    .padding(15.dp)
                    .fillMaxWidth()
            ) {
                Text("Log In", color = Color.White)
            }

            // Sign Up for Facebook
            ClickableText(
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(color = Color.White)) {
                        append("Sign Up for Facebook")
                    }
                    addStringAnnotation(
                        tag = "URL",
                        annotation = "https://www.facebook.com/signup",
                        start = 0,
                        end = length
                    )
                },
                onClick = {// Your logic here
                },
                modifier = Modifier.padding(top = 100.dp)
            )

            // Need Help?
            ClickableText(
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(color = Color.White)) {
                        append("Need Help?")
                    }
                    addStringAnnotation(
                        tag = "URL",
                        annotation = "https://www.facebook.com/help",
                        start = 0,
                        end = length
                    )
                },
                onClick = {// Your logic here
                },
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}



@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@RequiresApi(Build.VERSION_CODES.Q)
@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Task2Theme {
        var emailOrPhoneNumber by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }

        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .background(colorResource(id = R.color.background))
        ) {
            Text(
                text = "facebook",
                modifier = Modifier
                    .padding(top = 200.dp),
                color = Color.White,
                fontSize = 50.sp,
                fontWeight = FontWeight.Bold
            )

            // Email or phone number
            TextField(
                value = emailOrPhoneNumber,
                onValueChange = { emailOrPhoneNumber = it },
                label = { Text("Email or phone number") },
                modifier = Modifier
                    .padding(15.dp)
                    .fillMaxWidth()
                    .background(Color.White)
            )

            // Password
            TextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                modifier = Modifier
                    .padding(15.dp)
                    .fillMaxWidth()
                    .background(Color.White)
            )

            // Button
            Button(
                onClick = {
                    // Your login logic here
                },
                colors = ButtonDefaults.buttonColors(colorResource(R.color.purple_200)),
                modifier = Modifier
                    .padding(15.dp)
                    .fillMaxWidth()
            ) {
                Text("Log In", color = Color.White)
            }

            // Sign Up for Facebook
            ClickableText(
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(color = Color.White)) {
                        append("Sign Up for Facebook")
                    }
                    addStringAnnotation(
                        tag = "URL",
                        annotation = "https://www.facebook.com/signup",
                        start = 0,
                        end = length
                    )
                },
                onClick = {// Your logic here
                },
                modifier = Modifier.padding(top = 100.dp)
            )

            // Need Help?
            ClickableText(
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(color = Color.White)) {
                        append("Need Help?")
                    }
                    addStringAnnotation(
                        tag = "URL",
                        annotation = "https://www.facebook.com/help",
                        start = 0,
                        end = length
                    )
                },
                onClick = {// Your logic here
                },
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}