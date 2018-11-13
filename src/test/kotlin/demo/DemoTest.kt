package demo

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import kotlin.test.assertNotNull

/**
 * Created with IntelliJ IDEA.
 *
 * @author linux_china
 */

fun assertNotNullBlock(message: String? = null, block: () -> Any?) {
    val value = block()
    assertNotNull(value, message)
}


class DemoTest {

    @Test
    fun testFirst() = assertNotNullBlock("user not null") {
        "good"
    }

    @Test
    fun testYield() = runBlocking {

        val sequence = sequence {
            val start = 0
            // yielding a single value
            yield(start)
            // yielding an iterable
            yieldAll(1..5 step 2)
            // yielding an infinite sequence
            //yieldAll(generateSequence(8) { it * 3 })
        }
        println(sequence.toList())
    }

    @Test
    fun testAlso() = runBlocking {
        val r1 = async {
            for (i in 1..10) {
                println(Thread.currentThread().name)
                delay(10)
            }
        }
        delay(1000)

    }

}