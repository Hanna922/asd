package com.yourssu.restful_api1

import androidx.lifecycle.MutableLiveData

class ListLiveData<T>: MutableLiveData<MutableList<T>>() {
    private val temp = mutableListOf<T>()

    init {
        value = temp
    }

    fun addAll(items: List<T>) {
        temp.addAll(items)
        value = temp
    }
}