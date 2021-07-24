package com.ribisoft.gapodemo.data.model

import com.google.gson.annotations.SerializedName

data class NewsFeedResponse(
    @SerializedName("items")
    val items: List<Item>?
)