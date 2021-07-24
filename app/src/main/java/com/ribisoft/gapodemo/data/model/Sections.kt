package com.ribisoft.gapodemo.data.model

import com.google.gson.annotations.SerializedName

data class Section(
    @SerializedName("section_type")
    val sectionType: Int?,
    @SerializedName("content")
    val contents: Content?
)

data class Content(
    @SerializedName("text")
    val text: String?,
    @SerializedName("href")
    val href: String?,
    @SerializedName("caption")
    val caption: String?,
    @SerializedName("duration")
    val duration: Int?,
    @SerializedName("preview_image")
    val previewImage: Image?,
    @SerializedName("main_color")
    val mainColor: String?,
    @SerializedName("original_width")
    val originalWidth: Int?,
    @SerializedName("original_height")
    val originalHeight: Int?,
    @SerializedName("markups")
    val markups: List<Markup>?
)


data class Markup(
    @SerializedName("markup_type")
    val markupType: Int?,
    @SerializedName("start")
    val start: Int?,
    @SerializedName("end")
    val end: Int?
)