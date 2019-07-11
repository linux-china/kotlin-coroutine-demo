package demo

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

var retrofit = Retrofit.Builder()
    .baseUrl("https://httpbin.org/")
    .addConverterFactory(JacksonConverterFactory.create(ObjectMapper().registerKotlinModule()))
    .build()

val httpbinService = retrofit.create(HttpbinService::class.java)

/**
 * Httpbin Service test
 *
 * @author linux_china
 */
class HttpbinServiceTest {

    @Test
    fun testIp() = runBlocking {
        println(httpbinService.ip().origin)
    }

    @Test
    fun testHeaders() = runBlocking {
        println(httpbinService.headers()["headers"]!!["Host"])
    }
}