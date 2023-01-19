package com.example.dodopizza

import android.graphics.drawable.Drawable

data class Categories(val id: Int, val name: String, var isSelected: Boolean = false)

data class Product(
    val id: Int,
    val type: Int,
    val name: String,
    val composition: String,
    val price: String,
    val image: Drawable?
)