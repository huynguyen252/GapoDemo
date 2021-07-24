package com.ribisoft.gapodemo.ui.newsfeed.fragment.topic

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.ribisoft.gapodemo.R
import com.ribisoft.gapodemo.data.model.Item
import com.ribisoft.gapodemo.databinding.FragmentTopicBinding
import com.ribisoft.gapodemo.ui.base.BaseFragment
import com.ribisoft.gapodemo.ui.details.DetailsActivity
import com.ribisoft.gapodemo.ui.newsfeed.fragment.topic.adapter.TopicAdapter
import org.koin.android.viewmodel.ext.android.viewModel


class TopicFragment : BaseFragment<FragmentTopicBinding>() {
    override val layoutRes: Int = R.layout.fragment_topic
    override val viewModel by viewModel<TopicViewModel>()

    private val dataList = mutableListOf<Item>()
    lateinit var adapter: TopicAdapter
    lateinit var itemDecorator : DividerItemDecoration

    companion object {
        @JvmStatic
        fun getInstance(): TopicFragment {
            return TopicFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewDataBinding = DataBindingUtil.inflate(inflater, layoutRes, container, false)
        viewDataBinding.lifecycleOwner = this
        viewDataBinding.rvNews.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        return viewDataBinding.root
    }

    override fun initView() {
        itemDecorator = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        itemDecorator.setDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.divider)!!)
        adapter =
            TopicAdapter(requireContext(), dataList, object : TopicAdapter.OnClickItemCallback {
                override fun onClickItem(item: Item) {
                    startActivity(Intent(context, DetailsActivity::class.java))
                }
            })
        viewModel.getItemList()
        viewDataBinding.fragment = this
        viewDataBinding.viewmodel = viewModel
    }

    override fun initEvent() {

    }

    override fun observeData() {
        viewModel.itemList.observe(this, {
            dataList.clear()
            dataList.addAll(it)
            adapter.notifyDataSetChanged()
            hideShimmer()
        })
    }

    override fun observeDataFail() {
        super.observeDataFail()
        viewModel.errorMessage.observe(this, {
            it?.let {
                Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun hideShimmer() {
        Handler(Looper.getMainLooper()).postDelayed({
            viewDataBinding.layoutLoading.visibility = GONE
        }, 1500)

    }

}

