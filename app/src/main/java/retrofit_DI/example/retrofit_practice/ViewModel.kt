package com.example.retrofit_practice

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit_DI.example.retrofit_practice.data.Data
import retrofit_DI.example.retrofit_practice.data.Data_Detail
import retrofit_DI.example.retrofit_practice.domain.DomainData
import retrofit_DI.example.retrofit_practice.domain.Domain_Detail
import javax.inject.Inject

/**
 * 2023-01-15
 * pureum
 */
@HiltViewModel
class ViewModel @Inject constructor(
    private val useCase:UseCase
)  : ViewModel() {

    private val _dataList = MutableLiveData<ArrayList<Data_Detail>>()
    val dataList: LiveData<ArrayList<Data_Detail>>
        get() = _dataList


    fun viewModelGetData(want :String ="") {
        val myData = ArrayList<Data_Detail>()
        viewModelScope.launch {
            try {
                val data = useCase.useCaseGetData().list
                if (data != null) {
                    for(i in data) {
                        if (want != "" && i.conzoneName.contains(want)) { myData.add(i) }
                        else if (want == "") { myData.add(i) }
                    }
                }
                _dataList.value = myData
            }catch (e:Exception){
                Log.e("TAG", "viewModelGetData: $e", )
            }
        }
    }
}