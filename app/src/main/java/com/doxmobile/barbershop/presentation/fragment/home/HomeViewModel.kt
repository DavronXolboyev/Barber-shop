package com.doxmobile.barbershop.presentation.fragment.home

import androidx.lifecycle.ViewModel
import com.doxmobile.data.datastore.usecase.GetHasTheUserChosenARoleUseCase
import com.doxmobile.data.datastore.usecase.GetUserRoleUseCase
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