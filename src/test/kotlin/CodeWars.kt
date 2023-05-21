import kotlin.test.*

internal class CodeWars {
    @Test
    fun `noSpace - removes spaces from a string`() {
        assertEquals("hello", noSpace(" hello "))
        assertEquals("8j8mBliB8gimjB8B8jlB", noSpace("8 j 8   mBliB8g  imjB8B8  jl  B"))
        assertEquals("88Bifk8hB8BB8BBBB888chl8BhBfd", noSpace("8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd"))
        assertEquals("8aaaaaddddr", noSpace("8aaaaa dddd r     "))
    }

    @Test
    fun `hero - does the hero have enough bullets to slay all the dragons`() {
        assertFalse { hero(0, 1) }
        assertFalse { hero(1, 1) }
        assertFalse { hero(2, 2) }
        assertFalse { hero(6, 4) }


        assertTrue { hero(0, 0) }
        assertTrue { hero(1, 0) }
        assertTrue { hero(2, 1) }
        assertTrue { hero(3, 1) }
        assertTrue { hero(6, 3) }
        assertTrue { hero(6, 2) }
    }

    @Test
    fun `twiceAsOld - how many years ago or until the father was or will be twice as old as his son`() {
        assertEquals(0, twiceAsOld(32, 16))
        assertEquals(1, twiceAsOld(31, 16))
        assertEquals(1, twiceAsOld(33, 16))

        assertEquals(22, twiceAsOld(36,7))
        assertEquals(5, twiceAsOld(55,30))
        assertEquals(0, twiceAsOld(42,21))
        assertEquals(20, twiceAsOld(22,1))
        assertEquals(29, twiceAsOld(29,0))
    }
}