package retrofit_DI.example.retrofit_practice.domain

import retrofit2.Call
import retrofit_DI.example.retrofit_practice.data.Data
import retrofit_DI.example.retrofit_practice.data.Data_Detail

/**
 * 2023-01-15
 * pureum
 */
interface DomainInterface {
    suspend fun domainGetData(): DomainData
}