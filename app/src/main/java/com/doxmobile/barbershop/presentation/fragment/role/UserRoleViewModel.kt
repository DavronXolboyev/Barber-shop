package com.doxmobile.barbershop.presentation.fragment.role

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.doxmobile.barbershop.util.Role
import com.doxmobile.domain.local.UpdateHasTheUserChosenARoleUseCase
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

/**
 * Created by Davron Xolboyev on 14.02.2023
 */
class UserRoleViewModel(
    private val updateHasTheUserChosenARoleUseCase: UpdateHasTheUserChosenARoleUseCase
) : ViewModel() {
    private val userRole = MutableStateFlow("")
    val isChosenRole = combine(userRole) { role -> role[0].isNotEmpty() }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = false
    )
    private val _canNavigateToHome = MutableStateFlow(false)
    val canNavigateToHome = _canNavigateToHome.asStateFlow()
    fun setAction(action: Action) = viewModelScope.launch {
        when (action) {
            Action.NavigateToHome -> {
                // TODO: save role
                updateHasTheUserChosenARoleUseCase.updateUserRole()
                _canNavigateToHome.emit(true)
            }
            is Action.SetUserRole -> {
                userRole.emit(action.role.name)
            }
        }
        _canNavigateToHome.emit(false)
    }
}

sealed interface Action {
    data class SetUserRole(val role: Role) : Action
    object NavigateToHome : Action
}