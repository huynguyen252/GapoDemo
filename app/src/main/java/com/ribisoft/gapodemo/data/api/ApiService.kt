package com.ribisoft.gapodemo.data.api

import com.ribisoft.gapodemo.data.model.Item
import com.ribisoft.gapodemo.data.model.NewsFeedResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("c22fcb05-407d-46ea-95d6-7c5849264b95")
    suspend fun getNews(): Response<NewsFeedResponse>

    @GET("4b63be06-5eee-49ec-aa4a-e059e9c87138")
    suspend fun getDetails(): Response<Item>

}