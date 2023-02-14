package com.doxmobile.barbershop.presentation.fragment.home

import androidx.lifecycle.ViewModel
import com.doxmobile.domain.local.GetHasTheUserChosenARoleUseCase

/**
 * Created by Davron Xolboyev on 14.02.2023
 */
class HomeViewModel(
    getHasTheUserChosenARoleUseCase: GetHasTheUserChosenARoleUseCase
) : ViewModel() {
    val hasTheUserChosenARole = getHasTheUserChosenARoleUseCase.getHasTheUserChosenARole()
}