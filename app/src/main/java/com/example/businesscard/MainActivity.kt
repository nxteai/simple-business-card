package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
        Column (modifier = modifier.padding(16.dp)){
            CreateAppHeader(
                name = "Name",
                title = "Title",
                modifier = Modifier.fillMaxWidth()
            )
            ContactInformation(
                number = "Number",
                socialMedia = "Social Media",
                email = "Email",
                phoneIcon = Icons.Filled.Phone,
                socialMediaIcon = Icons.Filled.AccountCircle,
                emailIcon = Icons.Filled.Email,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }


@Composable
fun CreateAppHeader(name: String, title: String, modifier: Modifier){
        Column(
            modifier = modifier.padding(16.dp),
            horizontalAlignment = CenterHorizontally,
        ) {
            Image(
                painter = painterResource(id = R.drawable.android_logo),
                contentDescription = "android logo",
                modifier = Modifier.size(100.dp) // Adjust the size as needed
            )
            Text(text = name)
            Text(text = title)
        }

    }


@Composable
fun InfoRow(icon: ImageVector, contentDescription: String, text: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
    ){
        Icon(imageVector = icon, contentDescription = contentDescription)
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = text)
    }
}

@Composable
fun ContactInformation(
    phoneIcon: ImageVector,
    socialMediaIcon: ImageVector,
    emailIcon: ImageVector,
    number: String,
    socialMedia: String,
    email: String,
    modifier: Modifier
) {
        Column(
            modifier = modifier.padding(16.dp),
            horizontalAlignment = CenterHorizontally,
            ) {
            InfoRow(icon = phoneIcon, contentDescription = "number",text = number)
            InfoRow(icon = socialMediaIcon, contentDescription = "social media",text = socialMedia)
            InfoRow(icon = emailIcon, contentDescription = "email", text = email)
            }
        }

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}
