package com.example.livedatasimpletest

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel: ViewModel() {
    
    private var resultLiveData= MutableLiveData<Int>()
    var res: Int = 0
    
    open fun getResult(): MutableLiveData<Int> {
        resultLiveData.value = res
        return resultLiveData
    }
    
    open fun updateNumbers(numb1: Int, numb2: Int) {
        resultLiveData.value = numb1 + numb2
    }
}