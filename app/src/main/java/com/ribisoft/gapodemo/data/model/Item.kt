package com.ribisoft.gapodemo.data.model

import com.google.gson.annotations.SerializedName

data class Item(
    @SerializedName("document_id")
    val documentId: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("content_type")
    val contentType: String?,
    @SerializedName("published_date")
    val publishedDate: String?,
    @SerializedName("publisher")
    val publisher: Publisher?,
    @SerializedName("origin_url")
    val originUrl: String?,
    @SerializedName("avatar")
    val avatar: Image?,
    @SerializedName("images")
    val images: List<Image>?,
    @SerializedName("content")
    val content: Content?,
    @SerializedName("duration")
    val duration: Int?,
    @SerializedName("sections")
    val sections: List<Section>?
)