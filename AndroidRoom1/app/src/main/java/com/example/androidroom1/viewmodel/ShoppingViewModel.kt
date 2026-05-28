package com.example.androidroom1.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidroom1.ShoppingDatabase
import com.example.androidroom1.entity.ShoppingItem
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class ShoppingViewModel(application: Application) : AndroidViewModel(application) {

    private val dao = ShoppingDatabase.getDatabase(application).shoppingDao()

    val items = dao.getAll()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    fun addItem(name: String) {
        viewModelScope.launch {
            dao.insert(ShoppingItem(name = name))
        }
    }

    fun updateItem(item: ShoppingItem, newName: String) {
        viewModelScope.launch {
            dao.update(item.copy(name = newName))
        }
    }

    fun deleteItem(item: ShoppingItem) {
        viewModelScope.launch {
            dao.delete(item)
        }
    }
}