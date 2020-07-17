package demo.reactor

import demo.UserService
import demo.UserServiceImpl
import kotlinx.coroutines.reactor.mono
import org.junit.jupiter.api.Test

/**
 * user service implementation test
 *
 * @author linux_china
 */
class UserServiceImplReactorTest {

    @Test
    fun testCoroutineMethods() {
        val clazz = UserService::class.java
        for (method in clazz.declaredMethods) {
            val parameterTypes = method.parameterTypes
            if (!parameterTypes.isEmpty()) {
                println(parameterTypes.last())
            }
        }
    }

    @Test
    fun testInvoke() {
        val userService = UserServiceImpl();
        val nick = mono {
            userService.getNickById(1)
        }.block()
        println(nick)
    }
}