package demo

import kotlinx.coroutines.flow.Flow

/**
 * User service
 *
 * @author linux_china
 */
interface UserService {
    suspend fun getNick(): String
    suspend fun getNickById(id: Int): String
    fun getAllNames(): Flow<String>
}


class UserServiceImpl : UserService {
    override suspend fun getNick(): String {
        return "linux_china"
    }

    override suspend fun getNickById(id: Int): String {
        return "good"
    }

    override fun getAllNames(): Flow<String> {
        TODO("Not yet implemented")
    }

}