package com.doxmobile.barbershop.presentation.fragment.home.profile.open_a_barbershop.createPrice

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.doxmobile.barbershop.util.Navigate
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreatePriceViewModel @Inject constructor() : ViewModel() {
    private val _prices = MutableStateFlow(listOf(CreatePrice()))
    val prices = _prices.asStateFlow()
    private val _navigate = MutableSharedFlow<Navigate>()
    val navigate = _navigate.asSharedFlow()
    fun addPrice(oldList: List<CreatePrice>) = viewModelScope.launch {
        if (_prices.value.isNotEmpty()) {
            val newList = oldList.toMutableList().subList(0, oldList.lastIndex)
            newList.add(CreatePrice(type = 1))
            newList.add(CreatePrice())
            _prices.emit(newList)
        }
    }

    fun navigateBack() = viewModelScope.launch {
        _navigate.emit(Navigate.BACK)
    }

    fun createWorkers(prices: List<CreatePrice>) {
        // TODO: Ishchilarni tekshirib, hammasi to‘g‘ri bo‘lsa, serverga jo‘natilsin
    }

}

data class CreatePrice(
    var hairStyle: String? = null,
    var cost: String? = null,
    val type: Int = 0
)
