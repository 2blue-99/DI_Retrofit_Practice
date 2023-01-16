package retrofit_DI.example.retrofit_practice.data

import android.util.Log
import retrofit2.Call
import retrofit2.Retrofit
import javax.inject.Inject


/**
 * 2023-01-16
 * pureum
 */
class RetrofitImpl @Inject constructor(
    private val retrofit: Retrofit
):RetrofitInterface{
    override suspend fun getData(): Data {
        Log.e("TAG", "getData: in ", )
        return retrofit.create(RetrofitInterface::class.java).getData()
    }
}