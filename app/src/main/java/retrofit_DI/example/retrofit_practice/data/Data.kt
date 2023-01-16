package retrofit_DI.example.retrofit_practice.data

import retrofit_DI.example.retrofit_practice.domain.DomainData
import retrofit2.Call

data class Data(
    val code: String,
    val count: Int,
    val list: List<Data_Detail>,
    val message: String
)

fun Data.toDomainData() : DomainData = DomainData(list)