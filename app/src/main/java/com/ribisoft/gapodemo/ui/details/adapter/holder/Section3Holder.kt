package com.ribisoft.gapodemo.ui.details.adapter.holder

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.ribisoft.gapodemo.data.model.Section
import com.ribisoft.gapodemo.databinding.ItemSection3Binding
import com.ribisoft.gapodemo.ui.details.adapter.SectionAdapter

class Section3Holder(
    private val itemBinding: ItemSection3Binding,
    private val context: Context,
    private val callback: SectionAdapter.OnClickItemCallback
) :
    RecyclerView.ViewHolder(itemBinding.root) {

    fun setData(section: Section, position: Int) {
        itemBinding.section = section
    }

}