package com.example.flash.data

import androidx.annotation.StringRes
import com.example.flash.R

object DataSource {

    fun loadCategories(): List<Categories>{

        return listOf<Categories>(
            Categories(stringResourceId = R.string.fresh_fruits, imageResourceId = R.drawable.fruits),
            Categories(R.string.munchies,R.drawable.munchies),
            Categories(R.string.bath_body, R.drawable.bathbody),
            Categories(R.string.Kitchen_essential, R.drawable.kitchen),
            Categories(R.string.Packages_Food,R.drawable.packaged),
            Categories(R.string.beverages, R.drawable.beverages),
            Categories(R.string.bread_and_biscuit, R.drawable.bread),
            Categories(R.string.sweet_tooth, R.drawable.sweet),
            Categories(R.string.fresh_vegetable, R.drawable.vegetables)
        )
    }

    fun loadItem(
        @StringRes categoryName : Int
    ): List<Items>{
        return listOf(
            Items(R.string.banana_robusta,R.string.fresh_fruits,"2 kg",60,R.drawable.banana),
            Items(R.string.papaya_semi_ripe,R.string.fresh_fruits,"1 kg",100,R.drawable.papaya),
            Items(R.string.pomegranate,R.string.fresh_fruits,"3 kg",65,R.drawable.pomogranate),
            Items(R.string.shimla_apple,R.string.fresh_fruits,"2 kg",240,R.drawable.apple),
            Items(R.string.pineapple,R.string.fresh_fruits,"4 kg",120,R.drawable.pineapple),
            Items(R.string.pepsi_can,R.string.beverages,"4 kg",120,R.drawable.pepsi),
        ).filter {
            it.itemCategoryID == categoryName
        }
    }
}