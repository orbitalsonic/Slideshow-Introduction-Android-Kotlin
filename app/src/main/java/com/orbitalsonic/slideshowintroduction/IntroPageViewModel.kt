package com.orbitalsonic.slideshowintroduction

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class IntroPageViewModel : ViewModel() {

    private val _index = MutableLiveData<Int>()
    val mPosition: LiveData<Int> = Transformations.map(_index) { it }
    fun setIndex(index: Int) {
        _index.value = index
    }
}