package retrofit_DI.example.retrofit_practice

import com.example.retrofit_practice.UseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit_DI.example.retrofit_practice.domain.DomainImpl
import retrofit_DI.example.retrofit_practice.domain.DomainInterface
import javax.inject.Singleton

/**
 * 2023-01-16
 * pureum
 */


@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    @Singleton
    fun provideUseCase(repo:DomainInterface): UseCase {
        return UseCase(repo)
    }
}