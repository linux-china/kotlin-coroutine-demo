package demo

import retrofit2.http.GET


data class Ip(var origin: String)

interface HttpbinService {
    @GET("/ip")
    suspend fun ip(): Ip

    @GET("/headers")
    suspend fun headers(): Map<String, Map<String, String>>
}




