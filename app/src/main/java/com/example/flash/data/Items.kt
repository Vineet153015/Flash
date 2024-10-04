package com.example.flash.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Items(

    @StringRes val stringResourceID : Int,
    @StringRes val itemCategoryID :Int,
    val itemQuantityID : String,
    val itemPrice :Int,
    @DrawableRes val imageResource :Int

)
