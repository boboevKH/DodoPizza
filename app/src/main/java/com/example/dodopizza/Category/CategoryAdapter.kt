package com.example.dodopizza.Category

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.dodopizza.Categories
import com.example.dodopizza.ItemDiffCallbackCategory
import com.example.dodopizza.R

class CategoryAdapter: ListAdapter<Categories, CategoryAdapter.CategoryViewHolder>(
    ItemDiffCallbackCategory()
        ){

    var onItemClick: ((Categories, Int) -> Unit)? = null
    //var categoryType: ((Int) -> Unit)? = null



    inner class CategoryViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    val textView = itemView.findViewById<TextView>(R.id.title_category)

        init {
            itemView.setOnClickListener {
                // само нажатие происходит здесь!
                onItemClick?.invoke(getItem(adapterPosition), adapterPosition)
            }
        }

        fun configure(category: Categories) {
            textView.text = category.name
            if(category.isSelected) {
                textView.setTextColor(itemView.context.resources.getColor(R.color.purple_500))
            } else {
                // если элемент не выбран!!!
                textView.setTextColor(itemView.context.resources.getColor(R.color.black))
            }
        }



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        val view = layoutInflater.inflate(R.layout.fragment_category, parent, false)

        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.configure(getItem(position))

    }




}


