//package com.example.retrofit_practice
//
//import android.util.Log
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.example.retrofit_practice.data.Data_Detail
//import com.example.retrofit_practice.domain.DomainData
//import kotlinx.coroutines.*
//
///**
// * 2023-01-15
// * pureum
// */
//class ViewModel : ViewModel() {
//    fun viewModelGetData(want :String ="") {
//        Log.e("TAG", "viewModelGetData: hi", )
//        CoroutineScope(Dispatchers.IO).launch {
//            val data = UseCase().useCaseGetData()
//            Log.e("TAG", "viewModelGetData: $data", )
//        }
//    }
//}