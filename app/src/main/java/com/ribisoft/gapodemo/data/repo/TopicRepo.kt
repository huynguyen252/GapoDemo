package com.ribisoft.gapodemo.data.repo

import com.ribisoft.gapodemo.data.api.ApiService
import com.ribisoft.gapodemo.data.model.Item
import com.ribisoft.gapodemo.data.model.NewsFeedResponse
import retrofit2.Response

interface TopicRepo {
    suspend fun getNewsFeed(): Response<NewsFeedResponse>
}

class TopicRepoImpl(private val api: ApiService) : TopicRepo{

    override suspend fun getNewsFeed(): Response<NewsFeedResponse> {
        return api.getNews()
    }

}