package com.example.dodopizza

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dodopizza.Category.CategoryAdapter
import com.example.dodopizza.Product_package.ProductAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var category_recyclerView: RecyclerView
    private lateinit var product_recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        category_recyclerView = findViewById(R.id.rv_category)
        category_recyclerView.layoutManager = LinearLayoutManager(
            this, LinearLayoutManager.HORIZONTAL,false)
        val adapter2 = ProductAdapter()
        val adapter1 = CategoryAdapter()
        adapter1.onItemClick = { category, index ->
            adapter1.submitList(getNewDataCategory(index))
            adapter2.submitList(getNewDataProduct(category.id))
        }
        adapter1.submitList(getNewDataCategory())
        category_recyclerView.adapter = adapter1


        product_recyclerView = findViewById(R.id.rv_product)
        product_recyclerView.layoutManager = LinearLayoutManager(
            this, LinearLayoutManager.VERTICAL, false
        )
        adapter2.submitList(getNewDataProduct())
        product_recyclerView.adapter = adapter2
    }



    fun getNewDataCategory(indexOfSelectedElement: Int? = null) : MutableList<Categories> {
        val newList = mutableListOf(
            Categories(1,"Комбо"),
            Categories(2,"Закуски"),
            Categories(3,"Пицца"),
            Categories(4, "Напитки"),
            Categories(5, "Десерт"),
        )

        newList.forEachIndexed { index, myString ->
            if (index == indexOfSelectedElement) {
                myString.isSelected = true
            }
        }
        return newList
    }


    fun getNewDataProduct(indexOfCategories: Int? = null) : MutableList<Product> {
        val newList = mutableListOf(
            Product(1,1,"3 пиццы", "Комбо 3 пиццы 30 см на любой вкус", "225 c",getDrawable(R.drawable.combo_1)),
            Product(2,1,"10 средних пицц", "10 пицц 30 см на любой вкус. Для компании из 20–30 человек", "675 c",getDrawable(R.drawable.combo_2)),
            Product(3,1,"2 пиццы", "Самое популярное комбо из 2 пицц 30 см. Большой выбор", "156 c",getDrawable(R.drawable.combo_3)),
            Product(4,1,"7 пиццы", "7 пицц 30 см на любой вкус. Для компании из 15–20 человек", "470 c",getDrawable(R.drawable.combo_4)),
            Product(5,1,"2 пиццы и напиток", "2 пиццы 25 см и напиток на выбор. Для компании из 2–4 человек", "99 c",getDrawable(R.drawable.combo_5)),
            Product(6,2,"Додстер", "Легендарная горячая закуска с цыплёнком, томатами, моцареллой, соусом ранч в тонкой пшеничной лепешке", "25 c",getDrawable(R.drawable.combo_1)),
            Product(7,3,"Пепперони", "Пепперони из цыпленка, томатный соус, увеличенная порция моцареллы", "79 c",getDrawable(R.drawable.pepperoni)),
        )



        if (indexOfCategories == null) {
            return newList
        } else {
            return newList.filter { it.type == indexOfCategories }.toMutableList()
        }
    }

}