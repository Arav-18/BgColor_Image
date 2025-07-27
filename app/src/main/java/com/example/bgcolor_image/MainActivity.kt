package com.example.bgcolor_image

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bgcolor_image.ui.theme.BgColor_ImageTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BgColor_ImageTheme {
                // Call your UI composable here
                ColorChangerApp()
            }
        }
    }
}

@Composable
fun ColorChangerApp() {
    // State to toggle red color on and off
    var isRed by remember { mutableStateOf(true) }

    // Choose background color based on state
    val backgroundColor = if (isRed) Color.Red else Color.White

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Hello Aravend!",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            isRed = !isRed  // Toggle color
        }) {
            Text(text = "Toggle Red Background")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BgColor_ImageTheme {
        ColorChangerApp()
    }
}
