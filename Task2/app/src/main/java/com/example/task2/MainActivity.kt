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
import androidx.constraintlayout.compose.ConstraintLayout
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
fun MainContent(uiState: TaskUIState) {
    ConstraintLayout (
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.background))
    ) {
        val (facebookText, email, password, login, signUp, help) = createRefs()
        Text(
            text = "facebook",
            color = Color.White,
            fontSize = 50.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.constrainAs(facebookText){
                top.linkTo(parent.top)
                //bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)

            }.padding(32.dp)
        )


        TextField(
            value = uiState.emailOrPhoneNumber,
            onValueChange = { uiState.emailOrPhoneNumber = it },
            label = { Text("Email or phone number") },
            modifier = Modifier
                .padding(15.dp)
                .fillMaxWidth()
                .background(Color.White).constrainAs(email){
                    top.linkTo(facebookText.bottom)
                    //bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )

        TextField(
            value = uiState.password,
            onValueChange = { uiState.password = it},
            label = { Text("Password") },
            modifier = Modifier
                .padding(horizontal = 15.dp)
                .fillMaxWidth()
                .background(Color.White).constrainAs(password){
                    top.linkTo(email.bottom)
                    //bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )


        Button(
            onClick = {
                // Your login logic here
            },
            colors = ButtonDefaults.buttonColors(colorResource(R.color.purple_200)),
            modifier = Modifier
                .padding(15.dp)
                .fillMaxWidth().constrainAs(login){
                    top.linkTo(password.bottom)
                    //bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        ) {
            Text("Log In", color = Color.White)
        }

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
            modifier = Modifier
                .padding(15.dp)
                .constrainAs(signUp){
                    top.linkTo(login.bottom)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(help.start)
                }
        )

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
            modifier = Modifier
                .padding(15.dp)
                .constrainAs(help){
                    top.linkTo(login.bottom)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(signUp.end)
                    end.linkTo(parent.end)
                }
        )
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    viewModel: MainViewModel = hiltViewModel()



) {
    Task2Theme {
        val uiState by viewModel.uiState.collectAsState()
        MainContent(uiState)


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
fun MainScreenPreview() {
    val taskUIState = TaskUIState("email@email.com","Password")
    MainContent(taskUIState)
}