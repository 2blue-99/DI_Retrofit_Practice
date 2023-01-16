package retrofit_DI.example.retrofit_practice.data

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

/**
 * 2023-01-12
 * pureum
 */
interface RetrofitInterface {
    @GET("trafficAmountByRealtime?key=0737203941&type=json")
    fun getData(): Call<Data>
}