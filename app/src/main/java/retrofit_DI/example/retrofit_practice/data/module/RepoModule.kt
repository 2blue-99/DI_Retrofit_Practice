package retrofit_DI.example.retrofit_practice.data.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit_DI.example.retrofit_practice.data.RetrofitImpl
import retrofit_DI.example.retrofit_practice.data.RetrofitInterface
import javax.inject.Singleton

/**
 * 2023-01-16
 * pureum
 */
@Module
@InstallIn(SingletonComponent::class)
object RepoModule {
    @Provides
    @Singleton
    fun provideData(retrofit: Retrofit): RetrofitInterface {
        return RetrofitImpl(retrofit)
    }
}