package demo

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.toList
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
}