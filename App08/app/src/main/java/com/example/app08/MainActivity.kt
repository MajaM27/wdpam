package com.example.app08

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.app08.ui.theme.App08Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            App08Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    App08Screen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun App08Screen(modifier: Modifier = Modifier) {

    Column(
        modifier = modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {

        Text(text = "KALKULATOR", style = MaterialTheme.typography.headlineSmall)

        Calculator()

        Divider()

        Text(text = "UNIKATOWE ZNAKI", style = MaterialTheme.typography.headlineSmall)

        UniqueCharsCounter()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Calculator() {

    var numberA by rememberSaveable { mutableStateOf("") }
    var numberB by rememberSaveable { mutableStateOf("") }
    var result by rememberSaveable { mutableStateOf("") }

    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {

        OutlinedTextField(
            value = numberA,
            onValueChange = { numberA = it },
            label = { Text("Number A") }
        )

        OutlinedTextField(
            value = numberB,
            onValueChange = { numberB = it },
            label = { Text("Number B") }
        )

        Text(text = "Result: $result")

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {

            Button(onClick = { result = add(numberA, numberB) }) {
                Text("Add")
            }

            Button(onClick = { result = subtract(numberA, numberB) }) {
                Text("Subtract")
            }
        }

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {

            Button(onClick = { result = multiply(numberA, numberB) }) {
                Text("Multiply")
            }

            Button(onClick = { result = divide(numberA, numberB) }) {
                Text("Divide")
            }
        }
    }
}

fun add(a: String, b: String): String {
    return safeCalc(a, b) { x, y -> x + y }
}

fun subtract(a: String, b: String): String {
    return safeCalc(a, b) { x, y -> x - y }
}

fun multiply(a: String, b: String): String {
    return safeCalc(a, b) { x, y -> x * y }
}

fun divide(a: String, b: String): String {
    return try {
        val x = a.toDouble()
        val y = b.toDouble()

        if (y == 0.0) {
            "Cannot divide by 0"
        } else {
            (x / y).toString()
        }
    } catch (e: Exception) {
        "Wrong input"
    }
}

fun safeCalc(a: String, b: String, op: (Double, Double) -> Double): String {
    return try {
        op(a.toDouble(), b.toDouble()).toString()
    } catch (e: Exception) {
        "Wrong input"
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UniqueCharsCounter() {

    var text by rememberSaveable { mutableStateOf("") }

    val uniqueCount = text
        .lowercase()
        .filter { !it.isWhitespace() }
        .toSet()
        .size

    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {

        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Enter text") }
        )

        Text(text = "Unique characters: $uniqueCount")
    }
}