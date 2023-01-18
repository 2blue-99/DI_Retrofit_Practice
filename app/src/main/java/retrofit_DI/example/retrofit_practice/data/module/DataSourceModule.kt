package retrofit_DI.example.retrofit_practice.data.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit_DI.example.retrofit_practice.data.RetrofitInterface
import retrofit_DI.example.retrofit_practice.domain.DomainImpl
import retrofit_DI.example.retrofit_practice.domain.DomainInterface
import javax.inject.Singleton

/**
 * 2023-01-16
 * pureum
 */

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {
    @Provides
    @Singleton
    fun provideRepo(domainInterface: RetrofitInterface): DomainInterface {
        return DomainImpl(domainInterface)
    }

}