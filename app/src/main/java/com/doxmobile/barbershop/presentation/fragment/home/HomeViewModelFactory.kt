package com.doxmobile.barbershop.presentation.fragment.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.doxmobile.domain.local.GetHasTheUserChosenARoleUseCase
import com.doxmobile.domain.local.GetUserRoleUseCase
import javax.inject.Inject

/**
 * Created by Davron Xolboyev on 14.02.2023
 */
class HomeViewModelFactory @Inject constructor(
    private val getHasTheUserChosenARoleUseCase: GetHasTheUserChosenARoleUseCase,
    private val getUserRoleUseCase: GetUserRoleUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return HomeViewModel(
            getHasTheUserChosenARoleUseCase = getHasTheUserChosenARoleUseCase,
            getUserRoleUseCase = getUserRoleUseCase
        ) as T
    }
}