package com.doxmobile.barbershop.presentation.fragment.home.profile.open_a_barbershop.create

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.doxmobile.barbershop.util.Navigate
import com.doxmobile.domain.model.create.CreateBarberShopReq
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

typealias IsCorrectPassword = Boolean

@HiltViewModel
class CreateBarberShopVM @Inject constructor() : ViewModel() {
    private val createBarberShopReq = MutableStateFlow(CreateBarberShopReq())

    private val _navigate = MutableSharedFlow<Navigate>()
    val navigate = _navigate.asSharedFlow()

    fun setToTime(time: String) {
        createBarberShopReq.update { it.copy(toTime = time) }
    }

    fun setFromTime(time: String) {
        createBarberShopReq.update { it.copy(fromTime = time) }
    }

    fun setName(name: String) {
        createBarberShopReq.update { it.copy(name = name) }
    }

    fun setUniqueName(uName: String) {
        createBarberShopReq.update { it.copy(uniqueName = uName) }
    }

    fun setPassword(password: String): IsCorrectPassword {
        password.forEach {
            if (it == ' ') {
                return false
            }
        }
        createBarberShopReq.update { it.copy(password = password) }
        return true
    }

    fun isPasswordSame(password: String) = createBarberShopReq.value.password == password

    fun createBarberShop() = viewModelScope.launch {
        // TODO: Sartarishxona yaratish
        _navigate.emit(Navigate.NEXT)

    }

    fun navigateBack() {
        viewModelScope.launch {
            _navigate.emit(Navigate.BACK)
        }
    }
}