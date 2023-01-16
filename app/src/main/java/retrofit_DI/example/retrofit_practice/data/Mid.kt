package retrofit_DI.example.retrofit_practice.data

import android.util.Log
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit

/**
 * 2023-01-15
 * pureum
 */
class Mid {
    fun mid(): Call<Data> {
        return RetrofitImpl.getData().create(RetrofitInterface::class.java).getData()
    }
}