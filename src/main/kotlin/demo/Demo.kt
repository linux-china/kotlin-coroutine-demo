@file:Suppress("EXPERIMENTAL_IS_NOT_ENABLED")
@file:OptIn(DelicateCoroutinesApi::class)

package demo

import kotlinx.coroutines.*

suspend fun doSomething(name: String) = coroutineScope {
    println(name)
}

suspend fun doSomethingUsefulOne(): Int {
    delay(1000L) // pretend we are doing something useful here
    return 13
}


suspend fun doSomethingUsefulTwo(): Int {
    delay(1000L) // pretend we are doing something useful here, too
    return 29
}


suspend fun main(args: Array<String>) {
    coroutineScope {
        // create new coroutine in common thread pool
        val result = doSomethingUsefulOne()
        println("World! $result") // print after delay
    }
    GlobalScope.launch {
        // create new coroutine in common thread pool
        delay(100L) // non-blocking delay for 1 second (default time unit is ms)
        println("Jacky!") // print after delay
    }
    println("Hello,") // main function continues while coroutine is delayed
    doSomething("leijuan")
    Thread.sleep(2000L) // block main thread for 2 seconds to keep JVM alive
}