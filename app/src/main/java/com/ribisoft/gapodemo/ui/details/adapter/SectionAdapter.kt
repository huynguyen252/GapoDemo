package com.ribisoft.gapodemo.ui.details.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.ribisoft.gapodemo.R
import com.ribisoft.gapodemo.data.model.Item
import com.ribisoft.gapodemo.data.model.Section
import com.ribisoft.gapodemo.ui.details.adapter.holder.Section1Holder
import com.ribisoft.gapodemo.ui.details.adapter.holder.Section2Holder
import com.ribisoft.gapodemo.ui.details.adapter.holder.Section3Holder
import com.ribisoft.gapodemo.ui.details.adapter.holder.TopHolder
import com.ribisoft.gapodemo.ui.newsfeed.fragment.topic.adapter.holder.*
import com.ribisoft.gapodemo.utils.Constant
import com.ribisoft.gapodemo.utils.Constant.DetailsType.TYPE_BLANK
import com.ribisoft.gapodemo.utils.Constant.DetailsType.TYPE_TOP

class SectionAdapter(
    private val context: Context,
    private var dataList: List<Section>,
    private var callback: OnClickItemCallback
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var item: Item? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_TOP -> {
                TopHolder(
                    DataBindingUtil.inflate(
                        LayoutInflater.from(parent.context),
                        R.layout.item_top, parent, false
                    ),
                    context,
                    callback
                )
            }
            Constant.DetailsType.TYPE_1 -> {
                Section1Holder(
                    DataBindingUtil.inflate(
                        LayoutInflater.from(parent.context),
                        R.layout.item_section1, parent, false
                    ),
                    context,
                    callback
                )
            }
            Constant.DetailsType.TYPE_2 -> {
                Section2Holder(
                    DataBindingUtil.inflate(
                        LayoutInflater.from(parent.context),
                        R.layout.item_section2, parent, false
                    ),
                    context,
                    callback
                )
            }
            Constant.DetailsType.TYPE_3 -> {
                Section3Holder(
                    DataBindingUtil.inflate(
                        LayoutInflater.from(parent.context),
                        R.layout.item_section3, parent, false
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
            is TopHolder -> {
                item?.let { holder.setData(it, position) }
            }
            is Section1Holder -> {
                holder.setData(dataList[position], position)
            }
            is Section2Holder -> {
                holder.setData(dataList[position], position)
            }
            is Section3Holder -> {
                holder.setData(dataList[position], position)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return dataList[position].sectionType ?: TYPE_BLANK
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    interface OnClickItemCallback {
        fun onClickItem(section: Section)
    }

}
