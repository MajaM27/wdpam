package com.example.androidroom1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androidroom1.ui.theme.ShoppingScreen
import com.example.androidroom1.viewmodel.ShoppingViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val viewModel: ShoppingViewModel = viewModel()
            ShoppingScreen(viewModel)
        }
    }
}