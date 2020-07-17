package demo

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.reactor.asFlux
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

/**
 * Flow test
 *
 * @author linux_china
 */
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

    @Test
    fun testIntropWithReactor() = runBlocking {
        val flow1 = flowOf(1, 2, 3)
        flow1.asFlux()
    }

    @Test
    fun testStateFlowStateFlow() = runBlocking {
        val stateFlow = MutableStateFlow<Int>(0)

        // Observe values
        val job = launch {
            stateFlow.collect {
                print("$it ")
            }
        }

        // Change values
        (1..5).forEach {
            delay(500)
            stateFlow.value = it
        }

        // Cancel running job
        job.cancel()
        job.join()
    }
}