package com.doxmobile.barbershop.di.module

import com.doxmobile.domain.local.*
import dagger.Module
import dagger.Provides

/**
 * Created by Davron Xolboyev on 14.02.2023
 */
@Module
class DomainModule {

    @Provides
    fun provideAppStorageUseCase(appStorageRepository: AppStorageRepository): AppStorageUseCase =
        AppStorageUseCase(
            appStorageRepository = appStorageRepository
        )

    @Provides
    fun provideGetHasTheUserChosenARoleUseCase(appStorageRepository: AppStorageRepository): GetHasTheUserChosenARoleUseCase =
        GetHasTheUserChosenARoleUseCase(
            appStorageRepository = appStorageRepository
        )

    @Provides
    fun provideUpdateHasTheUserChosenARoleUseCase(appStorageRepository: AppStorageRepository): UpdateHasTheUserChosenARoleUseCase =
        UpdateHasTheUserChosenARoleUseCase(
            appStorageRepository = appStorageRepository
        )

    @Provides
    fun provideGetUserRoleUseCase(appStorageRepository: AppStorageRepository): GetUserRoleUseCase =
        GetUserRoleUseCase(
            appStorageRepository = appStorageRepository
        )

    @Provides
    fun provideSetRoleUseCase(appStorageRepository: AppStorageRepository): SetRoleUseCase =
        SetRoleUseCase(
            appStorageRepository = appStorageRepository
        )

}