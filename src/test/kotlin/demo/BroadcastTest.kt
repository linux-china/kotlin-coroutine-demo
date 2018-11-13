package demo

import kotlinx.coroutines.channels.broadcast
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

/**
 * Created with IntelliJ IDEA.
 *
 * @author linux_china
 */
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