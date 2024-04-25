package com.doxmobile.barbershop.presentation.fragment.role

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.doxmobile.data.datastore.usecase.SetRoleUseCase
import com.doxmobile.data.datastore.usecase.UpdateHasTheUserChosenARoleUseCase
import com.doxmobile.domain.model.Role
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Davron Xolboyev on 14.02.2023
 */

@HiltViewModel
class UserRoleViewModel @Inject constructor(
    private val updateHasTheUserChosenARoleUseCase: UpdateHasTheUserChosenARoleUseCase,
    private val setRoleUseCase: SetRoleUseCase
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
                setRoleUseCase.setRole(userRole.value)
                updateHasTheUserChosenARoleUseCase.updateUserRole(isChosen = true)
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