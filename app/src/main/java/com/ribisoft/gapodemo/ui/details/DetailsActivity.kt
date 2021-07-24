package com.ribisoft.gapodemo.ui.details

import android.os.Handler
import android.view.View.GONE
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ribisoft.gapodemo.R
import com.ribisoft.gapodemo.data.model.Section
import com.ribisoft.gapodemo.databinding.ActivityDetailsBinding
import com.ribisoft.gapodemo.ui.base.BaseActivity
import com.ribisoft.gapodemo.ui.details.adapter.SectionAdapter
import com.ribisoft.gapodemo.ui.details.adapter.holder.Section2Holder
import com.ribisoft.gapodemo.utils.Constant.DetailsType.TYPE_TOP
import org.koin.android.viewmodel.ext.android.viewModel

class DetailsActivity : BaseActivity<ActivityDetailsBinding>() {

    override val layoutRes: Int = R.layout.activity_details
    override val viewModel by viewModel<DetailsViewModel>()

    private val dataList = mutableListOf<Section>()
    lateinit var adapter: SectionAdapter
    var oldPosition = 0;

    override fun initView() {
        viewModel.getDetailList()
        val itemDecorator = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        itemDecorator.setDrawable(ContextCompat.getDrawable(this, R.drawable.white_divider)!!)
        viewDataBinding.rvDetails.addItemDecoration(itemDecorator)
        viewDataBinding.rvDetails.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        adapter =
            SectionAdapter(this, dataList, object : SectionAdapter.OnClickItemCallback {
                override fun onClickItem(section: Section) {

                }
            })
        viewDataBinding.rvDetails.adapter = adapter
        setPlayVideo()
        viewDataBinding.activity = this
        viewDataBinding.viewmodel = viewModel
    }

    override fun initEvent() {

    }

    override fun observeData() {
        viewModel.item.observe(this, {
            dataList.clear()
            it.sections?.let { it1 -> dataList.addAll(it1) }
            adapter.item = it
            dataList.add(0, Section(TYPE_TOP, null))
            adapter.notifyDataSetChanged()
            hideShimmer()
        })
    }

    override fun onBack() {
        finish()
    }

    override fun observeDataFail() {
        super.observeDataFail()
        viewModel.errorMessage.observe(this, {

        })
    }

    private fun setPlayVideo() {
        viewDataBinding.rvDetails.addOnScrollListener(object : RecyclerView.OnScrollListener() {

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
            }

            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (newState === RecyclerView.SCROLL_STATE_IDLE) {
                    val nowPos = getCurrentItem()
                    val nowHolder =
                        viewDataBinding.rvDetails.findViewHolderForAdapterPosition(nowPos)
                    val oldHolder =
                        viewDataBinding.rvDetails.findViewHolderForAdapterPosition(oldPosition)
                    if (nowHolder is Section2Holder
                        && oldPosition != nowPos
                    ) {
                        oldPosition = getCurrentItem()
                        //nowHolder.playVideo()
                    } else if (oldHolder is Section2Holder
                        && oldPosition != nowPos
                    ) {
                        oldHolder.pauseVideo()
                        oldPosition = getCurrentItem()
                    }
                }
            }

        })

    }

    private fun getCurrentItem(): Int {
        return ((viewDataBinding.rvDetails.layoutManager as LinearLayoutManager)
            .findFirstVisibleItemPosition() +
                (viewDataBinding.rvDetails.layoutManager as LinearLayoutManager).findLastVisibleItemPosition()) / 2
    }

    private fun hideShimmer() {
        Handler(mainLooper).postDelayed({
            (viewDataBinding.rvDetails.layoutManager as LinearLayoutManager).scrollToPositionWithOffset(
                0,
                0
            )
            viewDataBinding.layoutLoading.visibility = GONE
        }, 1500)

    }

}

