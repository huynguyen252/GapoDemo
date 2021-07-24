package com.ribisoft.gapodemo.app

import android.app.Application
import com.ribisoft.gapodemo.di.apiModule
import com.ribisoft.gapodemo.di.repositoryModule
import com.ribisoft.gapodemo.di.viewModelModule
import com.ribisoft.gapodemo.di.retrofitModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        //Koin
        startKoin {
            androidLogger()
            androidContext(this@MyApplication)
            modules(
                retrofitModule,
                repositoryModule,
                viewModelModule,
                apiModule
            )
        }
    }

}