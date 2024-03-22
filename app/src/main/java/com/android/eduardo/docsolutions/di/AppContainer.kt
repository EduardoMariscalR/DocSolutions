package com.android.eduardo.docsolutions.di

import android.content.Context
import com.android.eduardo.docsolutions.core.RetrofitServiceBuilder
import com.android.eduardo.docsolutions.data.remote.ApiService
import com.android.eduardo.docsolutions.data.remote.DocSolutionsRepository
import com.android.eduardo.docsolutions.data.remote.NetworkDocSolutionsRepository

interface AppContainer {
    val docSolutionsRepository: DocSolutionsRepository
}

class DefaultAppContainer( private val context: Context) : AppContainer {
    private val baseUrl = "https://techhub.docsolutions.com/"

    private val retrofitService: ApiService by lazy {
        RetrofitServiceBuilder.buildService(baseUrl,ApiService::class.java)
    }

    override val docSolutionsRepository: DocSolutionsRepository by lazy {
        NetworkDocSolutionsRepository(
            retrofitService
        )
    }
}