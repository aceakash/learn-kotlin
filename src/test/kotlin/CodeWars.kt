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

    @Test
    fun `equal sides of an array`() {
        assertEquals(3, findEvenIndex(intArrayOf(1, 2, 3, 4, 3, 2, 1)))
        assertEquals(1, findEvenIndex(intArrayOf(1, 100, 50, -51, 1, 1)))
        assertEquals(-1, findEvenIndex(intArrayOf(1, 2, 3, 4, 5, 6)))
        assertEquals(3, findEvenIndex(intArrayOf(20, 10, 30, 10, 10, 15, 35)))
        assertEquals(-1, findEvenIndex(intArrayOf(-8505, -5130, 1926, -9026)))
        assertEquals(1, findEvenIndex(intArrayOf(2824, 1774, -1490, -9084, -9696, 23094)))
        assertEquals(6, findEvenIndex(intArrayOf(4, 5, 6, 7, 8, 9, 10, 9, 8, 7, 6, 5, 4)))
        assertEquals(0, findEvenIndex(intArrayOf(1, 3, -3)))
    }

    @Test
    fun `partition a list in all combinations`() {
        var actual = partlist(arrayOf("a", "b"))
        assertEquals(1, actual.size)
        assertContentEquals(arrayOf("a", "b"), actual[0])

        actual = partlist(arrayOf("a", "b", "c"))
        assertEquals(2, actual.size)
        assertContentEquals(arrayOf("a", "b c"), actual[0])
        assertContentEquals(arrayOf("a b", "c"), actual[1])
    }

    @Test
    fun `to camel case`() {
        assertEquals("", toCamelCase(""))
        assertEquals("theStealthWarrior", toCamelCase("the_stealth_warrior"))
        assertEquals("TheStealthWarrior", toCamelCase("The-Stealth-Warrior"))
        assertEquals("ABC", toCamelCase("A-B-C"))
    }

    fun testing(n: Long, expect: String) {
        val actual = removNb(n)
        assertEquals(expect, actual.contentDeepToString())
    }

    @Test
    fun basicTests() {
        testing(26, "[[15, 21], [21, 15]]")
        testing(101, "[[55, 91], [91, 55]]")
        testing(102, "[[70, 73], [73, 70]]")
        testing(100, "[]")

    }

    @Test
    fun removeNbTest() {
        assertEquals("[[15, 21], [21, 15]]", removNb(26).contentDeepToString())
        assertEquals("[[55, 91], [91, 55]]", removNb(101).contentDeepToString())
        assertEquals("[[70, 73], [73, 70]]", removNb(102).contentDeepToString())
        assertEquals("[]", removNb(100).contentDeepToString())
    }

    @Test
    fun longestRepetitionTest() {
        assertEquals(Pair('a',4), longestRepetition("aaaabb"))
        assertEquals(Pair('a',4), longestRepetition("bbbaaabaaaa"))
        assertEquals(Pair('u',3), longestRepetition("cbdeuuu900"))
        assertEquals(Pair('b',5), longestRepetition("abbbbb"))
        assertEquals(Pair('a',2), longestRepetition("aabb"))
        assertEquals(Pair(null,0), longestRepetition(""))
        assertEquals(Pair('b',1), longestRepetition("ba"))
    }

    @Test
    fun capitalizeTests() {
        assertEquals(listOf("AbCdEf", "aBcDeF"), capitalize("abcdef"))
        assertEquals(listOf("CoDeWaRs", "cOdEwArS"), capitalize("codewars"))
        assertEquals(listOf("AbRaCaDaBrA", "aBrAcAdAbRa"), capitalize("abracadabra"))
        assertEquals(listOf("CoDeWaRrIoRs", "cOdEwArRiOrS"), capitalize("codewarriors"))
    }

    @Test
    fun getVowelCountTests() {
        assertEquals(5, getVowelCount("abracadabra"))
        assertEquals(1, getVowelCount("test"))
        assertEquals(3, getVowelCount("example"))
    }

    @Test
    fun highestAndLowestTests() {
        assertEquals("42 -9", highestAndLowest("8 3 -5 42 -1 0 0 -9 4 7 4 -4"))
        assertEquals("3 1", highestAndLowest("1 2 3"))
    }

    @Test
    fun growthOfPopulationTests() {
        assertEquals(15, growthOfPopulation(1500, 5.0, 100, 5000))
        assertEquals(10, growthOfPopulation(1500000, 2.5, 10000, 2000000))
    }

    @Test
    fun alphabeticalSequenceTests() {
        assertEquals("Eeeee,Ggggggg,Llllllllllll,Nnnnnnnnnnnnnn,Nnnnnnnnnnnnnn,Pppppppppppppppp,Qqqqqqqqqqqqqqqqq,Rrrrrrrrrrrrrrrrrr,Uuuuuuuuuuuuuuuuuuuuu,Xxxxxxxxxxxxxxxxxxxxxxxx,Zzzzzzzzzzzzzzzzzzzzzzzzzz", alphabeticalSequence("ZpglnRxqenU"))
        assertEquals("Bb,Eeeee,Ffffff,Ffffff,Ggggggg,Llllllllllll,Nnnnnnnnnnnnnn,Sssssssssssssssssss,Yyyyyyyyyyyyyyyyyyyyyyyyy,Yyyyyyyyyyyyyyyyyyyyyyyyy,Yyyyyyyyyyyyyyyyyyyyyyyyy", alphabeticalSequence("NyffsGeyylB"))
        assertEquals("Bb,Jjjjjjjjjj,Kkkkkkkkkkk,Mmmmmmmmmmmmm,Ooooooooooooooo,Qqqqqqqqqqqqqqqqq,Rrrrrrrrrrrrrrrrrr,Tttttttttttttttttttt,Uuuuuuuuuuuuuuuuuuuuu,Uuuuuuuuuuuuuuuuuuuuu,Vvvvvvvvvvvvvvvvvvvvvv", alphabeticalSequence("MjtkuBovqrU"))
        assertEquals("Dddd,Eeeee,Iiiiiiiii,Jjjjjjjjjj,Kkkkkkkkkkk,Mmmmmmmmmmmmm,Mmmmmmmmmmmmm,Nnnnnnnnnnnnnn,Ooooooooooooooo,Uuuuuuuuuuuuuuuuuuuuu,Vvvvvvvvvvvvvvvvvvvvvv", alphabeticalSequence("EvidjUnokmM"))
        assertEquals("Bb,Bb,Ccc,Ccc,Dddd,Eeeee,Hhhhhhhh,Iiiiiiiii,Nnnnnnnnnnnnnn,Vvvvvvvvvvvvvvvvvvvvvv,Xxxxxxxxxxxxxxxxxxxxxxxx", alphabeticalSequence("HbideVbxncC"))
    }

    @Test
    fun getMiddleCharacterTests() {
        assertEquals("ab", getMiddleCharacter("ab"));
        assertEquals("es", getMiddleCharacter("test"));
        assertEquals("dd", getMiddleCharacter("middle"));
        assertEquals("t", getMiddleCharacter("testing"));
        assertEquals("A", getMiddleCharacter("A"));
        assertEquals("s", getMiddleCharacter("asa"));
        assertEquals("D", getMiddleCharacter("asDsa"));
    }
}