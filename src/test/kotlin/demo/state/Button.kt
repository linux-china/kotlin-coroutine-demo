package demo.state

import kotlinx.coroutines.flow.MutableStateFlow

/**
 * Created with IntelliJ IDEA.
 *
 * @author linux_china
 */
class Button {
    private val stateFlow = MutableStateFlow<String>("")
    
}