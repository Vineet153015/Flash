package com.example.flash.data

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
}