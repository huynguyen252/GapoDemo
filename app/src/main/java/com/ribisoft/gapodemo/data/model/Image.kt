package com.ribisoft.gapodemo.data.model

import com.google.gson.annotations.SerializedName

data class Image(
    @SerializedName("href")
    val href: String?,
    @SerializedName("main_color")
    val mainColor: String?,
    @SerializedName("width")
    val width: Int?,
    @SerializedName("height")
    val height: Int?
)