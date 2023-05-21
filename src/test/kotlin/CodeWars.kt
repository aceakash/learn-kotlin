import kotlin.test.*

internal class CodeWars {
    @Test
    fun `noSpace - removes spaces from a string`() {
        assertEquals("hello", noSpace(" hello "))
        assertEquals("8j8mBliB8gimjB8B8jlB", noSpace("8 j 8   mBliB8g  imjB8B8  jl  B"))
        assertEquals("88Bifk8hB8BB8BBBB888chl8BhBfd", noSpace("8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd"))
        assertEquals("8aaaaaddddr", noSpace("8aaaaa dddd r     "))
    }
}