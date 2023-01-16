package retrofit_DI.example.retrofit_practice.data

import retrofit_DI.example.retrofit_practice.domain.DomainData

data class Data(
    val list: List<Data_Detail>,
    val count: Int,
    val message: String,
    val code: String
)

fun Data.toDomainData() : DomainData = DomainData(list, code)

