package retrofit_DI.example.retrofit_practice.data

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * 2023-01-15
 * pureum
 */


object RetrofitImpl{

    var myRetrofit =  Retrofit.Builder()

    fun getData(): Retrofit {
        Log.e("TAG", "getData: data쪽", )

        return myRetrofit
            .baseUrl("http://data.ex.co.kr/openapi/odtraffic/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}