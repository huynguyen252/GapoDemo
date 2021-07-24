package com.ribisoft.gapodemo.ui.newsfeed.fragment.topic.adapter.holder

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.ribisoft.gapodemo.data.model.Image
import com.ribisoft.gapodemo.databinding.ItemImageBinding

class ImageHolder(
    private val itemBinding: ItemImageBinding,
    private val context: Context
) :
    RecyclerView.ViewHolder(itemBinding.root) {

    fun setData(image: Image, position: Int) {
        itemBinding.image = image
    }

}