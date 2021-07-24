package com.ribisoft.gapodemo.ui.newsfeed.fragment.topic.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.ribisoft.gapodemo.R
import com.ribisoft.gapodemo.data.model.Item
import com.ribisoft.gapodemo.ui.details.adapter.holder.Section1Holder
import com.ribisoft.gapodemo.ui.newsfeed.fragment.topic.adapter.holder.*
import com.ribisoft.gapodemo.utils.Constant
import com.ribisoft.gapodemo.utils.Constant.HomeType.TYPE_BLANK

class TopicAdapter(
    private val context: Context,
    private var dataList: List<Item>,
    private var callback: OnClickItemCallback
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            Constant.HomeType.TYPE_OVERVIEW -> {
                OverviewHolder(
                    DataBindingUtil.inflate(
                        LayoutInflater.from(parent.context),
                        R.layout.item_overview, parent, false
                    ),
                    context,
                    callback
                )
            }
            Constant.HomeType.TYPE_ARTICLE -> {
                ArticleHolder(
                    DataBindingUtil.inflate(
                        LayoutInflater.from(parent.context),
                        R.layout.item_article, parent, false
                    ),
                    context,
                    callback
                )
            }
            Constant.HomeType.TYPE_GALLERY -> {
                GalleryHolder(
                    DataBindingUtil.inflate(
                        LayoutInflater.from(parent.context),
                        R.layout.item_gallery, parent, false
                    ),
                    context,
                    callback
                )
            }
            Constant.HomeType.TYPE_LONG_FORM -> {
                LongFormHolder(
                    DataBindingUtil.inflate(
                        LayoutInflater.from(parent.context),
                        R.layout.item_long_form, parent, false
                    ),
                    context,
                    callback
                )
            }
            Constant.HomeType.TYPE_STORY -> {
                StoryHolder(
                    DataBindingUtil.inflate(
                        LayoutInflater.from(parent.context),
                        R.layout.item_story, parent, false
                    ),
                    context,
                    callback
                )
            }
            Constant.HomeType.TYPE_VIDEO -> {
                VideoHolder(
                    DataBindingUtil.inflate(
                        LayoutInflater.from(parent.context),
                        R.layout.item_video, parent, false
                    ),
                    context,
                    callback
                )
            }
            else -> BlankHolder(
                DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context),
                    R.layout.item_blank, parent, false
                )
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is OverviewHolder -> {
                holder.setData(dataList[position], position)
            }
            is ArticleHolder -> {
                holder.setData(dataList[position], position)
            }
            is StoryHolder -> {
                holder.setData(dataList[position], position)
            }
            is GalleryHolder -> {
                holder.setData(dataList[position], position)
            }
            is LongFormHolder -> {
                holder.setData(dataList[position], position)
            }
            is VideoHolder -> {
                holder.setData(dataList[position], position)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (dataList[position].contentType) {
            "article" -> {
                Constant.HomeType.TYPE_ARTICLE
            }
            "gallery" -> {
                Constant.HomeType.TYPE_GALLERY
            }
            "long_form" -> {
                Constant.HomeType.TYPE_LONG_FORM
            }
            "overview" -> {
                Constant.HomeType.TYPE_OVERVIEW
            }
            "story" -> {
                Constant.HomeType.TYPE_STORY
            }
            "video" -> {
                Constant.HomeType.TYPE_VIDEO
            }
            else -> TYPE_BLANK
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    interface OnClickItemCallback {
        fun onClickItem(item: Item)
    }

}
