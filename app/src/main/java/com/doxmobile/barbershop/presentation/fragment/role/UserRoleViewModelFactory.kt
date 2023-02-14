package com.doxmobile.barbershop.presentation.fragment.role

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.doxmobile.domain.local.UpdateHasTheUserChosenARoleUseCase

/**
 * Created by Davron Xolboyev on 14.02.2023
 */
class UserRoleViewModelFactory(private val updateHasTheUserChosenARoleUseCase: UpdateHasTheUserChosenARoleUseCase) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UserRoleViewModel(updateHasTheUserChosenARoleUseCase = updateHasTheUserChosenARoleUseCase) as T
    }
}