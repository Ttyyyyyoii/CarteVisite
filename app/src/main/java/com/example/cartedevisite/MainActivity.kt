package com.example.cartedevisite

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cartedevisite.ui.theme.CarteDeVisiteTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.material3.IconButton

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CarteDeVisiteTheme {
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
    Box(
        modifier = modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center,

    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier

                .padding(bottom = 80.dp)
        ) {
            // Logo Android
            Image(
                painter = painterResource(id = R.drawable.android_logo),
                contentDescription = "Android Logo",
                modifier = Modifier
                    .size(200.dp)
                    .padding(0.dp),
                contentScale = ContentScale.Crop
            )

            // Nom et métier
            Text(text = "Ouattara",
                fontSize = 32.sp,
                color = Color(0xFF3ddc84)
            )
            Text(
                text = "Développeur Android",
                fontSize = 25.sp,

                color = Color.LightGray)
        }

        // Coordonnées en bas
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 40.dp)
        ) {
            // Téléphone
            ContactRow(
                icon = Icons.Filled.Phone,
                contactText = "+225 123 456 789"
            )
            ContactRow(
                icon = Icons.Filled.Email,
                contactText = "christjonathan@gmail.com"
            )
            // Email
            ContactRow(
                icon = Icons.Filled.Share,
                contactText = "Partager l'application"
            )
        }
    }
}

@Composable
fun ContactRow(icon: ImageVector, contactText: String, modifier: Modifier=Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(8.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color(0xFF3ddc84),
            modifier = Modifier.size(24.dp)
        )

        Text(
            text = contactText,
            fontSize = 18.sp,
            color = Color.Gray,
            modifier=Modifier
                .padding(start = 10.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    CarteDeVisiteTheme {
        BusinessCard()
    }
}
