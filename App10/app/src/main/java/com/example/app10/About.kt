package com.example.app10

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun About(
    navController: NavController,
    direction: String,
    year: String
) {

    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text("O autorze")

        Text("Imię i nazwisko: Maja Marczewska")
        Text("Kierunek: $direction")
        Text("Rok studiów: $year")

        Button(onClick = { navController.navigate(Routes.menu) }) {
            Text("Powrót do menu")
        }
    }
}