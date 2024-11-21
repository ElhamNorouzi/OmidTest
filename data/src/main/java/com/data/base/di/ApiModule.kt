package com.data.base.di

import com.data.list.ProductListApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApiModule {

    @Provides
    @Singleton
    fun provideListApi(retrofit: Retrofit): ProductListApi = retrofit.create(ProductListApi::class.java)
}