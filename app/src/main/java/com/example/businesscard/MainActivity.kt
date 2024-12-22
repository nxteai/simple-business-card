package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BusinessCard(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun BusinessCard(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        CreateAppHeader(
            name = "Name",
            title = "Title",
            modifier = Modifier.weight(1f)
        )
        ContactInformation(
            number = "Number",
            socialMedia = "Social Media",
            email = "Email",
            modifier = Modifier.weight(1f))
    }
}

@Composable
fun CreateAppHeader(name: String, title: String, modifier: Modifier){
    Box(modifier = modifier) {
        Column {
            Text(text = name)
            Text(text = title)
        }

    }
}

@Composable
fun ContactInformation(number: String, socialMedia: String, email: String, modifier: Modifier) {
    Box(modifier = modifier) {
        Column {
            Text(text = number)
            Text(text = socialMedia)
            Text(text = email)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CreateAppHeaderPreview() {
    BusinessCardTheme {
        CreateAppHeader("Name", "Title", Modifier.fillMaxSize())
    }
}
