package com.doxmobile.barbershop.presentation.fragment.role

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.doxmobile.domain.local.SetRoleUseCase
import com.doxmobile.domain.local.UpdateHasTheUserChosenARoleUseCase

/**
 * Created by Davron Xolboyev on 14.02.2023
 */
class UserRoleViewModelFactory(
    private val updateHasTheUserChosenARoleUseCase: UpdateHasTheUserChosenARoleUseCase,
    private val setRoleUseCase: SetRoleUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UserRoleViewModel(
            updateHasTheUserChosenARoleUseCase = updateHasTheUserChosenARoleUseCase,
            setRoleUseCase = setRoleUseCase
        ) as T
    }
}