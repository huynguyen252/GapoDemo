package com.ribisoft.gapodemo.ui.newsfeed.activity

import android.view.MenuItem
import com.google.android.material.navigation.NavigationBarView
import com.ribisoft.gapodemo.R
import com.ribisoft.gapodemo.databinding.ActivityNewsfeedBinding
import com.ribisoft.gapodemo.ui.base.BaseActivity
import com.ribisoft.gapodemo.ui.newsfeed.activity.adapter.NewsFeedPagerAdapter
import com.ribisoft.gapodemo.ui.newsfeed.fragment.account.AccountFragment
import com.ribisoft.gapodemo.ui.newsfeed.fragment.home.HomeFragment
import org.koin.android.viewmodel.ext.android.viewModel

class NewsFeedActivity : BaseActivity<ActivityNewsfeedBinding>() {

    override val layoutRes: Int = R.layout.activity_newsfeed
    override val viewModel by viewModel<NewsFeedViewModel>()

    private lateinit var adapter: NewsFeedPagerAdapter

    override fun initView() {
        adapter = NewsFeedPagerAdapter(supportFragmentManager)
        adapter.addFrag(HomeFragment.getInstance(), "Home")
        adapter.addFrag(AccountFragment.getInstance(), "Account")
        viewDataBinding.vpNewsfeed?.adapter = adapter
        viewDataBinding.vpNewsfeed?.setNavigation(
            viewDataBinding.bnvNewsFeed
        ) { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    viewDataBinding.vpNewsfeed.currentItem = 0
                }
                R.id.navigation_account -> {
                    viewDataBinding.vpNewsfeed.currentItem = 1
                }
            }
            true
        }
        viewDataBinding.activity = this
        viewDataBinding.viewModel = viewModel
    }

    override fun initEvent() {

    }

    override fun observeData() {

    }

    override fun onBack() {
        finish()
    }

}
