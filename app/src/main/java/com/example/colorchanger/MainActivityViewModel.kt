package com.example.colorchanger

import android.graphics.Color
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel: ViewModel() {

    private var _redColor = MutableLiveData<Int>()
    private var _blueColor = MutableLiveData<Int>()
    private var _greenColor = MutableLiveData<Int>()

    init{
        _redColor.value = 0
        _blueColor.value = 0
        _greenColor.value = 0
    }

    private var _viewColor = MutableLiveData<Int>()
    val viewColor : LiveData<Int> = _viewColor

    fun updateRedColor(color: Int){
        _redColor.value = color
        updateColor()
    }

    fun updateGreenColor(color: Int){
        _greenColor.value = color
        updateColor()
    }
    fun updateBlueColor(color: Int){
        _blueColor.value = color
        updateColor()
    }

    fun updateColor(){
        _viewColor.value = Color.argb(255, _redColor.value!!, _greenColor.value!!, _blueColor.value!!)
    }


}