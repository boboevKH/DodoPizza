package com.example.dodopizza.Product_package

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.dodopizza.ItemDiffCallbackProduct
import com.example.dodopizza.Product
import com.example.dodopizza.R

class ProductAdapter: ListAdapter<Product, ProductAdapter.ProductViewHolder> (
    ItemDiffCallbackProduct()
        ) {


    inner class ProductViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val image = itemView.findViewById<ImageView>(R.id.img_prd)
        val title = itemView.findViewById<TextView>(R.id.title_prd)
        val composition = itemView.findViewById<TextView>(R.id.composition_prd)
        val price = itemView.findViewById<TextView>(R.id.price_prd)




        fun configure(product: Product) {
            title.text = product.name
            composition.text = product.composition
            price.text = product.price
            image.setImageDrawable(product.image)


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.fragment_product,parent,false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.configure(getItem(position))
    }
}