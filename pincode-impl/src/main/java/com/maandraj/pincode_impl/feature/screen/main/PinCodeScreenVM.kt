package com.maandraj.pincode_impl.feature.screen.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maandraj.core.utils.asLiveData
import kotlinx.coroutines.launch

class PinCodeScreenVM : ViewModel() {

    private val _pinCode = MutableLiveData<Int>()
    val pinCode = _pinCode.asLiveData()

    fun setPinCode(pinCode: Int) = viewModelScope.launch {
        _pinCode.postValue(pinCode)
    }

}