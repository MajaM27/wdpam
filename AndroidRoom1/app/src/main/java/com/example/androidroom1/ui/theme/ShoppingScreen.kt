package com.example.androidroom1.ui.theme

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.androidroom1.entity.ShoppingItem
import com.example.androidroom1.viewmodel.ShoppingViewModel

@Composable
fun ShoppingScreen(viewModel: ShoppingViewModel) {

    val items by viewModel.items.collectAsState()
    var text by remember { mutableStateOf("") }
    var editingItem by remember { mutableStateOf<ShoppingItem?>(null) }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {

        Row {
            TextField(
                value = text,
                onValueChange = { text = it },
                modifier = Modifier.weight(1f),
                placeholder = { Text("Product name") }
            )

            Spacer(modifier = Modifier.width(8.dp))

            Button(onClick = {
                if (text.isNotBlank()) {
                    if (editingItem == null) {
                        viewModel.addItem(text)
                    } else {
                        viewModel.updateItem(editingItem!!, text)
                        editingItem = null
                    }
                    text = ""
                }
            }) {
                Text(if (editingItem == null) "Add" else "Save")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(items) { item ->

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = item.name,
                        modifier = Modifier.weight(1f)
                    )

                    Button(onClick = {
                        editingItem = item
                        text = item.name
                    }) {
                        Text("Edit")
                    }

                    Spacer(modifier = Modifier.width(8.dp))

                    Button(onClick = {
                        viewModel.deleteItem(item)
                    }) {
                        Text("Delete")
                    }
                }
            }
        }
    }
}