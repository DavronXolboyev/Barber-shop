package com.doxmobile.barbershop.di.module

import android.content.Context
import com.doxmobile.data.datastore.AppStorage
import com.doxmobile.data.datastore.repository.AppStorageImpl
import com.doxmobile.domain.local.AppStorageRepository
import dagger.Module
import dagger.Provides

/**
 * Created by Davron Xolboyev on 14.02.2023
 */
@Module
class DataModule {
    @Provides
    fun bindAppStorage(context: Context): AppStorage = AppStorage(context)

    @Provides
    fun bindAppStorageRepository(appStorage: AppStorage): AppStorageRepository =
        AppStorageImpl(appStorage)
}