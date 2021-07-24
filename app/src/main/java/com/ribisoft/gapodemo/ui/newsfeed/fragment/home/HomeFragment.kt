package com.ribisoft.gapodemo.ui.newsfeed.fragment.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.ribisoft.gapodemo.R
import com.ribisoft.gapodemo.databinding.FragmentHomeBinding
import com.ribisoft.gapodemo.ui.base.BaseFragment
import com.ribisoft.gapodemo.ui.newsfeed.fragment.home.adapter.HomePagerAdapter
import com.ribisoft.gapodemo.ui.newsfeed.fragment.topic.TopicFragment
import org.koin.android.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    override val layoutRes: Int = R.layout.fragment_home
    override val viewModel by viewModel<HomeViewModel>()

    private lateinit var adapter: HomePagerAdapter

    companion object {
        @JvmStatic
        fun getInstance(): HomeFragment {
            return HomeFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewDataBinding = DataBindingUtil.inflate(inflater, layoutRes, container, false)
        viewDataBinding.lifecycleOwner = this
        return viewDataBinding.root
    }


    override fun initView() {
        adapter = HomePagerAdapter(childFragmentManager)
        createTopicTab()
        viewDataBinding.vpTopic.adapter = adapter
    }

    override fun initEvent() {

    }

    override fun observeData() {

    }

    private fun createTopicTab() {
        adapter.addFrag(TopicFragment.getInstance(), "Theo dõi")
        adapter.addFrag(TopicFragment.getInstance(), "Cho bạn")
        adapter.addFrag(TopicFragment.getInstance(), "Bóng đá")
        adapter.addFrag(TopicFragment.getInstance(), "Công nghệ")
        adapter.addFrag(TopicFragment.getInstance(), "Đời sống")
        adapter.addFrag(TopicFragment.getInstance(), "Làm đẹp")
        adapter.addFrag(TopicFragment.getInstance(), "Sức khỏe")
        adapter.addFrag(TopicFragment.getInstance(), "Giới trẻ")
    }

}

