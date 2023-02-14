package com.doxmobile.barbershop.presentation.fragment.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.doxmobile.domain.local.GetHasTheUserChosenARoleUseCase

/**
 * Created by Davron Xolboyev on 14.02.2023
 */
class HomeViewModelFactory(private val getHasTheUserChosenARoleUseCase: GetHasTheUserChosenARoleUseCase) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return HomeViewModel(getHasTheUserChosenARoleUseCase = getHasTheUserChosenARoleUseCase) as T
    }
}