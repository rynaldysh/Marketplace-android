package com.example.marketplace.core.di

import com.example.marketplace.core.data.source.local.LocalDataSource
import com.example.marketplace.core.data.source.remote.RemoteDataSource
import com.example.marketplace.core.data.source.remote.network.ApiConfig
import org.koin.dsl.module

val appModule = module {
    single { ApiConfig.instanceRetrofit }

    single { RemoteDataSource(get()) }

    single { LocalDataSource() }
}