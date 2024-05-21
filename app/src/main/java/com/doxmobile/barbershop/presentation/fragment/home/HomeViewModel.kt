package com.doxmobile.barbershop.presentation.fragment.home

import androidx.lifecycle.ViewModel
import com.doxmobile.domain.GetHasTheUserChosenARoleUseCase
import com.doxmobile.domain.GetUserRoleUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by Davron Xolboyev on 14.02.2023
 */
@HiltViewModel
class HomeViewModel @Inject constructor(
    getHasTheUserChosenARoleUseCase: GetHasTheUserChosenARoleUseCase,
    getUserRoleUseCase: GetUserRoleUseCase
) : ViewModel() {
    val hasTheUserChosenARole = getHasTheUserChosenARoleUseCase.getHasTheUserChosenARole()
    val role = getUserRoleUseCase.getRole()
}