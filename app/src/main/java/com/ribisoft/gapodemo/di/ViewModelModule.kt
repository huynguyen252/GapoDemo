package com.ribisoft.gapodemo.di

import com.ribisoft.gapodemo.ui.details.DetailsViewModel
import com.ribisoft.gapodemo.ui.newsfeed.activity.NewsFeedViewModel
import com.ribisoft.gapodemo.ui.newsfeed.fragment.home.HomeViewModel
import com.ribisoft.gapodemo.ui.newsfeed.fragment.topic.TopicViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by HuyNguyenCao on 3/15/2021.
 */

val viewModelModule = module {
    viewModel {
        NewsFeedViewModel(get(), get())
    }
    viewModel {
        DetailsViewModel(get(), get())
    }

    viewModel {
        TopicViewModel(get(), get())
    }

    viewModel {
        HomeViewModel(get(), get())
    }
}
