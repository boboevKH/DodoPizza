package com.example.dodopizza

import androidx.recyclerview.widget.DiffUtil

class ItemDiffCallbackCategory : DiffUtil.ItemCallback<Categories>() {
    override fun areItemsTheSame(
        oldItem: Categories,
        newItem: Categories
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: Categories,
        newItem: Categories
    ): Boolean {
        return oldItem == newItem
    }
}

class ItemDiffCallbackProduct : DiffUtil.ItemCallback<Product>() {
    override fun areItemsTheSame(
        oldItem: Product,
        newItem: Product
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: Product,
        newItem: Product
    ): Boolean {
        return oldItem == newItem
    }
}