package retrofit_DI.example.retrofit_practice.data.module

import android.util.Log
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton


/**
 * 2023-01-15
 * pureum
 */
@Module
@InstallIn(SingletonComponent::class)
object RetrofitNetwork{
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        Log.e("TAG", "getData: data쪽", )
        return Retrofit.Builder()
            .baseUrl("http://data.ex.co.kr/openapi/odtraffic/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}

