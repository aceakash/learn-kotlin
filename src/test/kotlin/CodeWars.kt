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

        assertEquals(22, twiceAsOld(36, 7))
        assertEquals(5, twiceAsOld(55, 30))
        assertEquals(0, twiceAsOld(42, 21))
        assertEquals(20, twiceAsOld(22, 1))
        assertEquals(29, twiceAsOld(29, 0))
    }

    @Test
    fun `roman numerals encoder-decoder`() {
        val romanToNumbers = arrayOf(
            Pair("I", 1),
            Pair("V", 5),
            Pair("X", 10),
            Pair("L", 50),
            Pair("C", 100),
            Pair("D", 500),
            Pair("M", 1000),
            Pair("II", 2),
            Pair("III", 3),
            Pair("XX", 20),
            Pair("XXX", 30),
            Pair("CC", 200),
            Pair("CCC", 300),
            Pair("MM", 2000),
            Pair("MMM", 3000),

            Pair("IV", 4),
            Pair("IX", 9),
            Pair("XL", 40),
            Pair("XC", 90),
            Pair("CD", 400),
            Pair("CM", 900),


            Pair("VI", 6),
            Pair("VIII", 8),
            Pair("XXI", 21),
            Pair("XXIII", 23),
            Pair("XI", 11),
            Pair("XII", 12),
            Pair("XV", 15),
            Pair("XXV", 25),
            Pair("XVII", 17),
            Pair("XLVIII", 48),

            Pair("LXVI", 66),
            Pair("MDCLXVI", 1666),

            Pair("XCI", 91),
            Pair("XCIX", 99),
        )
        for (td in romanToNumbers) {
            assertEquals(td.first, romanEncode(td.second))
            assertEquals(td.second, romanDecode(td.first))
        }
    }
}