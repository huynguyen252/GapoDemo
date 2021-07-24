package com.ribisoft.gapodemo.data.repo

import com.ribisoft.gapodemo.data.api.ApiService
import com.ribisoft.gapodemo.data.model.Item
import retrofit2.Response

interface DetailsRepo {
    suspend fun getDetails(): Response<Item>
}

class DetailsRepoImpl(private val api:ApiService) : DetailsRepo{

    override suspend fun getDetails(): Response<Item> {
        return api.getDetails()
    }

}