package demo

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

/**
 * Created with IntelliJ IDEA.
 *
 * @author linux_china
 */
class CoroutinesChannelTest {

    fun produceNumbers() = GlobalScope.produce<Int> {
        var x = 1 // start from 1
        while (true) {
            send(x++) // produce next
            delay(100) // wait 0.1s
        }
    }

    fun launchProcessor(id: Int, channel: ReceiveChannel<Int>) = GlobalScope.launch {
        channel.consumeEach {
            println("Processor #$id received $it")
        }
    }

    @Test
    fun testChannel() = runBlocking<Unit> {
        val producer = produceNumbers()
        repeat(5) { launchProcessor(it, producer) }
        delay(950)
        producer.cancel() // cancel producer coroutine and thus kill them all
    }
}