package com.ribisoft.gapodemo.ui.newsfeed.fragment.topic.adapter.holder

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ribisoft.gapodemo.data.model.Item
import com.ribisoft.gapodemo.databinding.ItemArticleBinding
import com.ribisoft.gapodemo.ui.newsfeed.fragment.topic.adapter.TopicAdapter

class ArticleHolder(
    private val itemBinding: ItemArticleBinding,
    private val context: Context,
    private val callback: TopicAdapter.OnClickItemCallback
) :
    RecyclerView.ViewHolder(itemBinding.root) {

    fun setData(item: Item, position: Int) {
        Glide.with(context).load(item.avatar?.href).into(itemBinding.ivAvatar)
        itemBinding.event = callback
        itemBinding.item = item
    }

}