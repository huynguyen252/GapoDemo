package com.ribisoft.gapodemo.ui.details.adapter.holder

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.ribisoft.gapodemo.data.model.Item
import com.ribisoft.gapodemo.databinding.ItemOverviewBinding
import com.ribisoft.gapodemo.databinding.ItemTopBinding
import com.ribisoft.gapodemo.ui.details.adapter.SectionAdapter
import com.ribisoft.gapodemo.ui.newsfeed.fragment.topic.adapter.TopicAdapter

class TopHolder(
    private val itemBinding: ItemTopBinding,
    private val context: Context,
    private val callback: SectionAdapter.OnClickItemCallback
) :
    RecyclerView.ViewHolder(itemBinding.root) {

    fun setData(item: Item, position: Int) {
        itemBinding.item = item
    }

}