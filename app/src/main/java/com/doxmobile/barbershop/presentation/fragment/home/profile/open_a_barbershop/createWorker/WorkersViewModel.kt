package com.doxmobile.barbershop.presentation.fragment.home.profile.open_a_barbershop.createWorker

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
class WorkersViewModel @Inject constructor() : ViewModel() {
    private val _workers = MutableStateFlow(listOf(CreateWorker()))
    val workers = _workers.asStateFlow()
    private val _navigate = MutableSharedFlow<Navigate>()
    val navigate = _navigate.asSharedFlow()
    fun addWorker(oldList: List<CreateWorker>) = viewModelScope.launch {
        if (_workers.value.isNotEmpty()) {
            val newList = oldList.toMutableList().subList(0, oldList.lastIndex)
            newList.add(CreateWorker(type = 1))
            newList.add(CreateWorker())
            _workers.emit(newList)
        }
    }

    fun navigateBack() = viewModelScope.launch {
        _navigate.emit(Navigate.BACK)
    }

    fun createWorkers(workers: List<CreateWorker>) = viewModelScope.launch{
        // TODO: Ishchilarni tekshirib, hammasi to‘g‘ri bo‘lsa, serverga jo‘natilsin
        _navigate.emit(Navigate.NEXT)
    }

}

data class CreateWorker(
    var name: String? = null,
    var phoneNumber: String? = null,
    val type: Int = 0
)
