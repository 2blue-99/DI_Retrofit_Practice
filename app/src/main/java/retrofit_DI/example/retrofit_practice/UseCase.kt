package com.example.retrofit_practice

import retrofit2.Call
import retrofit_DI.example.retrofit_practice.data.Data
import retrofit_DI.example.retrofit_practice.domain.DomainData
import retrofit_DI.example.retrofit_practice.domain.DomainInterface
import javax.inject.Inject


/**
 * 2023-01-15
 * pureum
 */
class UseCase @Inject constructor(
    private val repo : DomainInterface
) {
    suspend fun useCaseGetData(): DomainData {
        return repo.domainGetData()
    }
}