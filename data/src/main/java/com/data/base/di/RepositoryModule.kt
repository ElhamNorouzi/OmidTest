package com.data.base.di

import com.data.list.ProductListRepositoryImpl
import com.domain.product.ProductListRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindListRepository(repository: ProductListRepositoryImpl): ProductListRepository
}