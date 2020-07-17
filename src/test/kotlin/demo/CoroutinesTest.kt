package demo

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.selects.select
import org.junit.jupiter.api.Test

/**
 * coroutines test
 *
 * @author linux_china
 */
class CoroutinesTest {

    suspend fun sus1(): Int {
        return 1
    }
    suspend fun entrance() {
        println(sus1())
    }

    @Test
    fun testOne() {
        GlobalScope.launch {
            // create new coroutine in common thread pool
            entrance();
            delay(1000L) // non-blocking delay for 1 second (default time unit is ms)
            println("World!") // print after delay
        }
        println("Hello,") // main function continues while coroutine is delayed
        Thread.sleep(2000L) // block main thread for 2 seconds to keep JVM alive
    }

    @Test
    fun testMySuspendingFunction() = runBlocking {
        println("good")
    }

    @Test
    fun testAsync() {
        val deferred = GlobalScope.async {
            2
        }
        runBlocking {
            val sum = deferred.await();
            println("Sum: $sum")
        }
    }

    @Test
    fun testTwo() = runBlocking<Unit> {
        val job = launch {
            println("1111")
            delay(1000L)
            println("World!")
        }
        println("Hello,")
    }

    @Test
    fun testIOIntensive() = runBlocking<Unit> {
        val produce = produce<Int> {
            for (x in 1..5) {
                send(x * x)
            }
        }
        repeat(3) {
            select<Unit> {
                produce.onReceive() { println(it) }
            }
        }
        delay(1000)
    }
}