package com.android.eduardo.docsolutions.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitServiceBuilder {
    fun getRetrofitInstance( baseUrl: String): Retrofit {
        return Retrofit
            .Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build()
    }

    fun<T> buildService(baseUrl: String,service: Class<T>): T {
        return getRetrofitInstance(baseUrl).create(service)
    }
}