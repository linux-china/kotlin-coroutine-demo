Kotlin Coroutine Demo
=====================

# Vocabulary

* Coroutine: light thread
* CoroutineContext: Persistent context for the coroutine
* Channel: Deferred values provide a convenient way to transfer a single value between coroutines: SendChannel & ReceiveChannel
```
val channel = Channel<Int>()
```
* Fan-out: Multiple coroutines may receive from the same channel
* Fan-in: Multiple coroutines may send to the same channel
* Actors: An actor is a combination of a coroutine, the state(confined and encapsulated into this coroutine), and a channel to communicate with other coroutines
* Mutex: Mutual exclusion, mutex.withLock { counter++ }
* select: Select expression makes it possible to await multiple suspending functions simultaneously and select the first one that becomes available.

# References

* Kotlin coroutines: https://github.com/Kotlin/kotlinx.coroutines
* AtomicFU: https://github.com/Kotlin/kotlinx.atomicfu
