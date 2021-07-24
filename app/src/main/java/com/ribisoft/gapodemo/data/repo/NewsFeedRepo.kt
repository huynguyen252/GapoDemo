package com.ribisoft.gapodemo.data.repo

import com.ribisoft.gapodemo.data.api.ApiService
import com.ribisoft.gapodemo.data.model.Item
import com.ribisoft.gapodemo.data.model.NewsFeedResponse
import retrofit2.Response

interface NewsFeedRepo {
    suspend fun getNewsFeed(): Response<NewsFeedResponse>
}

class NewsFeedRepoImpl(private val api: ApiService) : NewsFeedRepo{

    override suspend fun getNewsFeed(): Response<NewsFeedResponse> {
        return api.getNews()
    }

}