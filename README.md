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

# Convert between Coroutines and Reactive

* Kotlin Coroutines Service with Flow

```kotlin
interface UserService {
    suspend fun getNick(): String
    suspend fun getNickById(id: Int): String
    fun getAllNames(): Flow<String>
}
```

* Kotlin compiled to Java. Continuation as last param of suspend method

```
public interface UserService {
  public abstract java.lang.Object getNick(kotlin.coroutines.Continuation<? super java.lang.String>);
  public abstract java.lang.Object getNickById(int, kotlin.coroutines.Continuation<? super java.lang.String>);
  public abstract kotlinx.coroutines.flow.Flow<java.lang.String> getAllNames();
}
```

# References

* Unit Testing Channels & Flows: https://speakerdeck.com/heyitsmohit/unit-testing-channels-and-flows-droidcon-americas
* Introduction to Coroutines and Channels: https://play.kotlinlang.org/hands-on/Introduction%20to%20Coroutines%20and%20Channels/01_Introduction
* Kotlin Coroutines: https://github.com/Kotlin/kotlinx.coroutines
* Kotlin Flow: https://kotlinlang.org/docs/reference/coroutines/flow.html
* AtomicFU: https://github.com/Kotlin/kotlinx.atomicfu
* Kotlin Coroutines 1.5: GlobalScope Marked as Delicate, Refined Channels API, and More: https://blog.jetbrains.com/kotlin/2021/05/kotlin-coroutines-1-5-0-released/
* Understanding Kotlin Coroutines: https://reflectoring.io/understanding-kotlin-coroutines-tutorial/
