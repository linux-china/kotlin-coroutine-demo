package demo

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.filter
import kotlinx.coroutines.channels.ticker
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

/**
 * Created with IntelliJ IDEA.
 *
 * @author linux_china
 */
class ChannelTest {

    @Test
    fun channelSend() = runBlocking<Unit> {
        val channel = Channel<Int>(100)
        launch {
            channel.filter { it % 2 == 1 }.consumeEach { println(it) }
        }
        launch {
            channel.filter { it % 2 == 0 }.consumeEach { println(it) }
        }
        for (x in 1..100) {
            launch {
                channel.send(x)
            }
        }
        delay(1000)
        println("Done!")
    }


    @Test
    fun tickerChannel() = runBlocking {
        val tickerChannel = ticker(delayMillis = 1000)

        launch {
            tickerChannel.consumeEach { println("dida") }
        }

        delay(10000)
        println("done")
    }
}