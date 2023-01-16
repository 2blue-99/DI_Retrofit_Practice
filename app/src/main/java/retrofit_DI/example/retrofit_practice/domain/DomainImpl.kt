package retrofit_DI.example.retrofit_practice.domain
import retrofit2.Call
import retrofit_DI.example.retrofit_practice.data.Data
import retrofit_DI.example.retrofit_practice.data.RetrofitImpl
import retrofit_DI.example.retrofit_practice.data.RetrofitInterface
import retrofit_DI.example.retrofit_practice.data.toDomainData
import javax.inject.Inject
/**
 * 2023-01-15
 * pureum
 */
class DomainImpl @Inject constructor(private val api: RetrofitInterface): DomainInterface {
    override suspend fun domainGetData(): DomainData {
        return api.getData().toDomainData()
    }
}