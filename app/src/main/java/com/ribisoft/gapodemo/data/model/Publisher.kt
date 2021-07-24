package com.ribisoft.gapodemo.data.model

import com.google.gson.annotations.SerializedName

data class Publisher (
    @SerializedName("id")
    val id: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("icon")
    val icon: String?
)