package com.doxmobile.barbershop.di.module

import android.content.Context
import com.doxmobile.barbershop.presentation.fragment.home.HomeViewModelFactory
import com.doxmobile.barbershop.presentation.fragment.role.UserRoleViewModelFactory
import com.doxmobile.domain.local.AppStorageUseCase
import com.doxmobile.domain.local.GetHasTheUserChosenARoleUseCase
import com.doxmobile.domain.local.UpdateHasTheUserChosenARoleUseCase
import dagger.Module
import dagger.Provides

/**
 * Created by Davron Xolboyev on 14.02.2023
 */
@Module
class AppModule(private val context: Context) {
    @Provides
    fun provideContext(): Context = context

    @Provides
    fun provideUserRoleViewModelFactory(updateHasTheUserChosenARoleUseCase: UpdateHasTheUserChosenARoleUseCase): UserRoleViewModelFactory =
        UserRoleViewModelFactory(updateHasTheUserChosenARoleUseCase = updateHasTheUserChosenARoleUseCase)

    @Provides
    fun provideHomeViewModelFactory(getHasTheUserChosenARoleUseCase: GetHasTheUserChosenARoleUseCase): HomeViewModelFactory =
        HomeViewModelFactory(getHasTheUserChosenARoleUseCase)
}