package com.sumup.challenge.toastcatalog.di.hiltModule

import com.sumup.challenge.toastcatalog.data.network.ItemApiService
import com.sumup.challenge.toastcatalog.data.network.NetworkClientProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideApiService(): ItemApiService {
        return NetworkClientProvider.instance.apiService
    }
}