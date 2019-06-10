package demo

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

/**
 * Flow test
 *
 * @author linux_china
 */
@ExperimentalCoroutinesApi
class FlowTest {

    @Test
    fun testFlow() = runBlocking {
        flowOf(1, 2, 3).map {
            it + 2
        }.collect { println(it) }
    }

    @Test
    fun testSingle() = runBlocking {
        val single = flowOf(1).single()
        println(single)
    }
}