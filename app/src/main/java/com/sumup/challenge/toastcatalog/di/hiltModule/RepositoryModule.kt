package com.sumup.challenge.toastcatalog.di.hiltModule

import com.sumup.challenge.toastcatalog.data.repository.ItemRepositoryImpl
import com.sumup.challenge.toastcatalog.domain.ItemRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindItemRepository(
        itemRepositoryImpl: ItemRepositoryImpl
    ): ItemRepository
}