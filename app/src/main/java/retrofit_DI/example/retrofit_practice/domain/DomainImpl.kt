package retrofit_DI.example.retrofit_practice.domain

import android.util.Log
import retrofit_DI.example.retrofit_practice.data.Data
import retrofit_DI.example.retrofit_practice.data.Data_Detail
import retrofit_DI.example.retrofit_practice.data.Mid
//import com.example.retrofit_practice.data.Mid
import retrofit_DI.example.retrofit_practice.data.toDomainData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * 2023-01-15
 * pureum
 */
//class DomainImpl: DomainInterface {
//    override fun domainGetData(): DomainData? {
//        return Mid().mid().body()?.toDomainData()
////        Mid().mid().enqueue(object : Callback<Data> {
////            override fun onResponse(call: Call<Data>, response: Response<Data>) {
////                gap = response.body()?.toDomainData()!!
////                Log.e("TAG", "domainGetData: $gap",)
////                //Log.e("TAG", "onResponse\n $gap", )
////            }
////            override fun onFailure(call: Call<Data>, t: Throwable) {
////            }
////        })
//    }
//}