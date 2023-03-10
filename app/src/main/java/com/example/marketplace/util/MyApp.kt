package com.example.marketplace.util


import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import com.example.marketplace.core.di.appModule
import com.example.marketplace.core.di.repositoryModule
import com.example.marketplace.core.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp : Application() {

    companion object{
        @SuppressLint("StaticFieldLeak")
        var context : Context? = null
    }
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApp)
            modules(listOf(appModule, viewModelModule, repositoryModule))
        }

        MyApp.context = applicationContext
    }
}