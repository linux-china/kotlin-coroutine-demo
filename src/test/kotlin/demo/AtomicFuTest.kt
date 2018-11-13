package demo

import kotlinx.atomicfu.atomic
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

data class Counter(var value: Int = 0)
/**
 * Created with IntelliJ IDEA.
 *
 * @author linux_china
 */
class AtomicFuTest {

    private val counter = atomic(0)
    private val globalObj = atomic(Counter())

    @Test
    fun testAtomic() = runBlocking {
        repeat(100) {
            launch {
                counter.addAndGet(1)
            }
        }
        delay(1000)
        println(counter.value)
    }

    @Test
    fun testAtomicAccount() = runBlocking {
        repeat(100) {
            launch {
                globalObj.getAndSet(Counter(11))
            }
        }
        delay(1000)
        println(globalObj.value.value)
    }
}