package com.example.app10
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun Cities(navController: NavController) {

    val cities = listOf(
        "Tokyo – 37 mln",
        "Delhi – 32 mln",
        "Shanghai – 29 mln",
        "Dhaka – 23 mln",
        "São Paulo – 22 mln",
        "Mexico City – 22 mln",
        "Cairo – 22 mln",
        "Mumbai – 21 mln",
        "Beijing – 21 mln",
        "Osaka – 19 mln"
    )

    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Miasta")

        cities.forEach {
            Text(it)
        }

        Button(onClick = { navController.navigate(Routes.menu) }) {
            Text("Powrót do menu")
        }
    }
}