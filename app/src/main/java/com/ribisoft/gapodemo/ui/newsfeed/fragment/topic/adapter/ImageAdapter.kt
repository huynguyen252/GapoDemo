package com.ribisoft.gapodemo.ui.newsfeed.fragment.topic.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.ribisoft.gapodemo.R
import com.ribisoft.gapodemo.data.model.Image
import com.ribisoft.gapodemo.ui.newsfeed.fragment.topic.adapter.holder.*

class ImageAdapter(
    private val context: Context,
    private var dataList: List<Image>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageHolder {
        return ImageHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_image, parent, false
            ), context
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ImageHolder).setData(dataList[position], position)
    }


    override fun getItemCount(): Int {
        return dataList.size
    }

}
