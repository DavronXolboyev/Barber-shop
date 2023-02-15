package com.doxmobile.barbershop.presentation.fragment.home

import androidx.lifecycle.ViewModel
import com.doxmobile.domain.local.GetHasTheUserChosenARoleUseCase
import com.doxmobile.domain.local.GetUserRoleUseCase

/**
 * Created by Davron Xolboyev on 14.02.2023
 */
class HomeViewModel(
    getHasTheUserChosenARoleUseCase: GetHasTheUserChosenARoleUseCase,
    getUserRoleUseCase: GetUserRoleUseCase
) : ViewModel() {
    val hasTheUserChosenARole = getHasTheUserChosenARoleUseCase.getHasTheUserChosenARole()
    val role = getUserRoleUseCase.getRole()
}