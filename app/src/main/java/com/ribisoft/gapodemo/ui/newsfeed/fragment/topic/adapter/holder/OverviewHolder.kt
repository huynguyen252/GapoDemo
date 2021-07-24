package com.ribisoft.gapodemo.ui.newsfeed.fragment.topic.adapter.holder

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.ribisoft.gapodemo.data.model.Item
import com.ribisoft.gapodemo.databinding.ItemOverviewBinding
import com.ribisoft.gapodemo.ui.newsfeed.fragment.topic.adapter.TopicAdapter

class OverviewHolder(
    private val itemBinding: ItemOverviewBinding,
    private val context: Context,
    private val callback: TopicAdapter.OnClickItemCallback
) :
    RecyclerView.ViewHolder(itemBinding.root) {

    fun setData(item: Item, position: Int) {
        itemBinding.event = callback
        itemBinding.item = item
    }

}