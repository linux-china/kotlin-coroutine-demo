package demo

import kotlinx.coroutines.reactive.consumeEach
import kotlinx.coroutines.reactor.mono
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

/**
 * coroutine reactor test
 *
 * @author linux_china
 */
class CoroutinesReactorTest {

    @Test
    fun testReactor() = runBlocking<Unit> {
        val user = mono {
            "good"
        }
        user.consumeEach { println(it) }
    }
}