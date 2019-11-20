package demo

import kotlinx.coroutines.delay
import kotlinx.coroutines.reactor.mono
import org.junit.jupiter.api.Test
import reactor.core.publisher.Mono

/**
 * coroutine reactor test
 *
 * @author linux_china
 */
class CoroutinesReactorTest {

    @Test
    fun testReactor() {
        val result = mono {
            asyncCall()
        }
        println(result.block())
    }

    @Test
    fun testReactorToJob() {
        val one = Mono.just("first")
    }


    private suspend fun asyncCall(): Int {
        delay(1000L) // pretend we are doing something useful here, too
        return 29
    }
}