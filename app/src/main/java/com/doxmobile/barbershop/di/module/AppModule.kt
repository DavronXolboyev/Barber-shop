package com.doxmobile.barbershop.di.module

import android.content.Context
import dagger.Module
import dagger.Provides

/**
 * Created by Davron Xolboyev on 14.02.2023
 */
@Module
class AppModule(private val context: Context) {
    @Provides
    fun provideContext(): Context = context
}