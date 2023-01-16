package com.example.retrofit_practice

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit_DI.example.retrofit_practice.data.Data
import javax.inject.Inject

/**
 * 2023-01-15
 * pureum
 */
@HiltViewModel
class ViewModel @Inject constructor(
    private val useCase:UseCase
)  : ViewModel() {

    fun viewModelGetData(want :String ="") {

        viewModelScope.launch {
            try {
                val data = useCase.useCaseGetData().code
                Log.e("TAG", "viewModelGetData: ${data}")
            }catch (e:Exception){
                Log.e("TAG", "viewModelGetData: $e", )
            }

        }
    }
}