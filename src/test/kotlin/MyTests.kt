import kotlin.test.Test
import kotlin.test.assertEquals

internal class MyTests {
    @Test
    fun greetTest() {
        assertEquals("Hello, world!", greet("world"))
    }
}
