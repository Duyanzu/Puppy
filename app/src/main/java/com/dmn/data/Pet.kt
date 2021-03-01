package com.dmn.data

import androidx.annotation.DrawableRes

data class Pet(
    val name: String,
    val varieties: String,
    val hobby: String,
    @DrawableRes val avatar: Int
)
