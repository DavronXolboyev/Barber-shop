package com.doxmobile.barbershop.di

import com.doxmobile.barbershop.di.module.AppModule
import com.doxmobile.barbershop.di.module.DataModule
import com.doxmobile.barbershop.di.module.DomainModule
import com.doxmobile.barbershop.presentation.activity.MainActivity
import com.doxmobile.barbershop.presentation.fragment.home.HomeFragment
import com.doxmobile.barbershop.presentation.fragment.role.UserRoleFragment

/**
 * Created by Davron Xolboyev on 14.02.2023
 */
@dagger.Component(modules = [AppModule::class, DataModule::class, DomainModule::class])
interface Component {
    fun inject(mainActivity: MainActivity)
    fun inject(userRoleFragment: UserRoleFragment)
    fun inject(homeFragment: HomeFragment)
}