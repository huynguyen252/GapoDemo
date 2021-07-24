package com.ribisoft.gapodemo.di

import com.ribisoft.gapodemo.data.api.ApiService
import org.koin.dsl.module
import retrofit2.Retrofit

/**
 * Created by HuyNguyenCao on 3/15/2021.
 */

val apiModule = module {
    fun provideUseApi(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    single { provideUseApi(get()) }
}