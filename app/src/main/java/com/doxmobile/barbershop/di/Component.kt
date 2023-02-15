package com.doxmobile.barbershop.di

import com.doxmobile.barbershop.di.module.AppModule
import com.doxmobile.barbershop.di.module.DataModule
import com.doxmobile.barbershop.di.module.DomainModule
import com.doxmobile.barbershop.presentation.activity.MainActivity
import com.doxmobile.barbershop.presentation.fragment.home.fav_barbershops_list.FavBarbershopsListFragment
import com.doxmobile.barbershop.presentation.fragment.home.barbershops_list.BarbershopsListFragment
import com.doxmobile.barbershop.presentation.fragment.home.HomeFragment
import com.doxmobile.barbershop.presentation.fragment.home.profile.ProfileFragment
import com.doxmobile.barbershop.presentation.fragment.role.UserRoleFragment

/**
 * Created by Davron Xolboyev on 14.02.2023
 */
@dagger.Component(modules = [AppModule::class, DataModule::class, DomainModule::class])
interface Component {
    fun inject(mainActivity: MainActivity)
    fun inject(userRoleFragment: UserRoleFragment)
    fun inject(homeFragment: HomeFragment)
    fun inject(barberShopsListFragment: BarbershopsListFragment)
    fun inject(favBarbershopsListFragment: FavBarbershopsListFragment)
    fun inject(profileFragment: ProfileFragment)
}