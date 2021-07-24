package com.ribisoft.gapodemo.di

import com.ribisoft.gapodemo.data.api.ApiService
import com.ribisoft.gapodemo.data.repo.DetailsRepoImpl
import com.ribisoft.gapodemo.data.repo.HomeRepoImpl
import com.ribisoft.gapodemo.data.repo.NewsFeedRepoImpl
import com.ribisoft.gapodemo.data.repo.TopicRepoImpl
import org.koin.dsl.module

/**
 * Created by HuyNguyenCao on 3/15/2021.
 */

val repositoryModule = module {
    fun provideNewsFeedRepository(apiService: ApiService): NewsFeedRepoImpl {
        return NewsFeedRepoImpl(apiService)
    }

    fun provideDetailsRepository(apiService: ApiService): DetailsRepoImpl {
        return DetailsRepoImpl(apiService)
    }

    fun provideHomeRepository(apiService: ApiService): HomeRepoImpl {
        return HomeRepoImpl(apiService)
    }

    fun provideTopicRepository(apiService: ApiService): TopicRepoImpl {
        return TopicRepoImpl(apiService)
    }

    single { provideNewsFeedRepository(get()) }
    single { provideDetailsRepository(get()) }
    single { provideHomeRepository(get()) }
    single { provideTopicRepository(get()) }

}