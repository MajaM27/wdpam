package com.example.androidroom1.dao

import androidx.room.*
import com.example.androidroom1.entity.ShoppingItem
import kotlinx.coroutines.flow.Flow

@Dao
interface ShoppingDao {

    @Insert
    suspend fun insert(item: ShoppingItem)

    @Update
    suspend fun update(item: ShoppingItem)

    @Delete
    suspend fun delete(item: ShoppingItem)

    @Query("SELECT * FROM shopping_items ORDER BY id DESC")
    fun getAll(): Flow<List<ShoppingItem>>
}