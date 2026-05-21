package com.example.app10

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun Buildings(navController: NavController) {

    val buildings = listOf(
        "Burj Khalifa – 828 m",
        "Shanghai Tower – 632 m",
        "Abraj Al Bait – 601 m",
        "Ping An Finance Center – 599 m",
        "Lotte World Tower – 555 m",
        "One World Trade Center – 541 m",
        "Guangzhou CTF Tower – 530 m",
        "Tianjin CTF Tower – 530 m",
        "CITIC Tower – 528 m",
        "Taipei 101 – 508 m"
    )

    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Budowle")

        buildings.forEach {
            Text(it)
        }

        Button(onClick = { navController.navigate(Routes.menu) }) {
            Text("Powrót do menu")
        }
    }
}