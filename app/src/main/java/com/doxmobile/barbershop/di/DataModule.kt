package com.doxmobile.barbershop.di

import android.content.Context
import com.doxmobile.data.datastore.AppStorage
import com.doxmobile.data.datastore.repository.AppStorageRepository
import com.doxmobile.data.datastore.repositoryImpl.AppStorageImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

/**
 * Created by Davron Xolboyev on 14.02.2023
 */
@Module
@InstallIn(SingletonComponent::class)
class DataModule {
    @Provides
    fun bindAppStorage(@ApplicationContext context: Context): AppStorage = AppStorage(context)

    @Provides
    fun bindAppStorageRepository(appStorage: AppStorage): AppStorageRepository =
        AppStorageImpl(appStorage)
}