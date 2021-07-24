package com.ribisoft.gapodemo.ui.newsfeed.fragment.topic.adapter.holder

import android.content.Context
import android.view.LayoutInflater
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.ribisoft.gapodemo.R
import com.ribisoft.gapodemo.data.model.Item
import com.ribisoft.gapodemo.databinding.ItemImageBinding
import com.ribisoft.gapodemo.databinding.ItemStoryBinding
import com.ribisoft.gapodemo.ui.newsfeed.fragment.topic.adapter.TopicAdapter

class StoryHolder(
    private val itemBinding: ItemStoryBinding,
    private val context: Context,
    private val callback: TopicAdapter.OnClickItemCallback
) :
    RecyclerView.ViewHolder(itemBinding.root) {

    fun setData(item: Item, position: Int) {
        itemBinding.lnImages.removeAllViews()
        item.images?.forEach {
            val childImage = DataBindingUtil.inflate<ItemImageBinding>(
                LayoutInflater.from(context),
                R.layout.item_image,
                null,
                false
            )
            childImage.image = it
            itemBinding.lnImages.addView(childImage.root)
        }
        itemBinding.event = callback
        itemBinding.item = item
    }

}