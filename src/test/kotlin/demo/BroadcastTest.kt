package demo

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.broadcast
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

/**
 * broadcast test
 *
 * @author linux_china
 */
@ExperimentalCoroutinesApi
class BroadcastTest {

    @Test
    fun testBroadcast() = runBlocking {
        val broadcast = broadcast<Int>(capacity = 10) {
        }
        broadcast.openSubscription().consumeEach { println(it) }
        broadcast.openSubscription().consumeEach { println(it + 1) }
        delay(1000)
    }
}