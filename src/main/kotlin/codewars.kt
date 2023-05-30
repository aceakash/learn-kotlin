import kotlin.math.absoluteValue

/*
https://www.codewars.com/kata/57eae20f5500ad98e50002c5/train/kotlin
Write a function that removes the spaces from the string, then return the resultant string.
 */
fun noSpace(x: String): String {
//    return x.replace(" ", "")
    return x.filterNot { it.isWhitespace() }
}

/*
https://www.codewars.com/kata/59ca8246d751df55cc00014c/train/kotlin
A hero is on his way to the castle to complete his mission. However, he's been told that the castle is surrounded with a couple of powerful dragons! each dragon takes 2 bullets to be defeated, our hero has no idea how many bullets he should carry.. Assuming he's gonna grab a specific given number of bullets and move forward to fight another specific given number of dragons, will he survive?
Return true if yes, false otherwise :)
 */
fun hero(bullets: Int, dragons: Int): Boolean {
    return bullets >= 2 * dragons
}

/*
https://www.codewars.com/kata/5b853229cfde412a470000d0/train/kotlin
Your function takes two arguments:

    current father's age (years)
    current age of his son (years)

Сalculate how many years ago the father was twice as old as his son (or in how many years he will be twice as old). The answer is always greater or equal to 0, no matter if it was in the past or it is in the future.
 */
fun twiceAsOld(dadYearsOld: Int, sonYearsOld: Int): Int {
    return ((sonYearsOld * 2) - dadYearsOld).absoluteValue
}

/*
Create a function taking a positive integer between 1 and 3999 (both included) as its parameter and returning a string containing the Roman Numeral representation of that integer.
 */
fun romanEncode(num: Int): String {
    val ts = arrayOf(
        Pair("M", 1000),
        Pair("CM", 900),
        Pair("D", 500),
        Pair("CD", 400),
        Pair("C", 100),
        Pair("XC", 90),
        Pair("L", 50),
        Pair("XL", 40),
        Pair("X", 10),
        Pair("IX", 9),
        Pair("V", 5),
        Pair("IV", 4),
        Pair("I", 1)
    )

    var encoded = ""
    var toEncode = num
    for (t in ts) {
        if (toEncode >= t.second) {
            val count = toEncode / t.second
            encoded += t.first.repeat(count)
            toEncode -= count * t.second
        }
    }
    return encoded
}

/*
Decode a roman numberal to regular (arabic) numbers
 */
fun romanDecode(roman: String): Int {
    val ts = arrayOf(
        Pair("M", 1000),
        Pair("CM", 900),
        Pair("D", 500),
        Pair("CD", 400),
        Pair("C", 100),
        Pair("XC", 90),
        Pair("L", 50),
        Pair("XL", 40),
        Pair("X", 10),
        Pair("IX", 9),
        Pair("V", 5),
        Pair("IV", 4),
        Pair("I", 1)
    ).reversed()
    var n = 0
    var s = roman
    for (t in ts) {
        while (s.endsWith(t.first)) {
            n += t.second
            s = s.substring(0, s.length - t.first.length)
        }
    }
    return n
}

/*
https://www.codewars.com/kata/5679aa472b8f57fb8c000047/train/kotlin
You are going to be given an array of integers. Your job is to take that array and find an index N where the sum of the integers to the left of N is equal to the sum of the integers to the right of N. If there is no index that would make this happen, return -1.
 */
fun findEvenIndex(arr: IntArray): Int {
    for (i in arr.indices) {
        val first = arr.take(i)
        val second = arr.drop(i + 1)
        if (first.sum() == second.sum()) {
            return i
        }
    }
    return -1
}

/*
https://www.codewars.com/kata/56f3a1e899b386da78000732/train/kotlin
Write a function partlist that gives all the ways to divide a list (an array) of at least two elements into two non-empty parts.
 */
fun partlist(arr: Array<String>): Array<Array<String>> {
    return (1..arr.lastIndex).map {
        arrayOf(arr.take(it).joinToString(" "), arr.drop(it).joinToString(" "))
    }.toTypedArray()
}

/*
https://www.codewars.com/kata/517abf86da9663f1d2000003/train/kotlin
Complete the method/function so that it converts dash/underscore delimited words into camel casing. The first word within the output should be capitalized only if the original word was capitalized (known as Upper Camel Case, also often referred to as Pascal case). The next words should be always capitalized.
 */
fun toCamelCase(str: String): String =
    str.replace('-', '_')
        .split('_')
        .mapIndexed { i, it ->
            if (i != 0) it.capitalize() else it
        }
        .joinToString("")

/*
https://www.codewars.com/kata/534d2f5b5371ecf8d2000a08/train/kotlin
Your task, is to create N×N multiplication table, of size provided in parameter.
 */
fun multiplicationTable(size: Int): Array<IntArray> {
    return (1..size).map { i ->
        (1..size).map { j -> i * j }.toIntArray()
    }.toTypedArray()
}

/*
https://www.codewars.com/kata/5547cc7dcad755e480000004/train/kotlin
 */
fun removNb(n: Long): Array<LongArray> {
    val o = mutableListOf<LongArray>()
    val sum = (1..n).sum()
    for (a in 1..n) {
        if ((sum - a) % (a + 1) != 0L) {
            continue
        }
        val b = (sum - a) / (a + 1)
        if (b in 1..n && b != a) {
            o.add(longArrayOf(a, b))
        }
    }
    return o.toTypedArray()
}

/*
https://www.codewars.com/kata/586d6cefbcc21eed7a001155/train/kotlin
For a given string s find the character c (or C) with longest consecutive repetition and return:
Pair(c, l)
 */
fun longestRepetition(s: String): Pair<Char?, Int> {
    var longest: Pair<Char?, Int> = Pair(null, 0)
    var prev: Char? = null
    var run = 0
    for (c in s) {
        if (prev == c) {
            run += 1
            continue
        }
        if (run > longest.second) {
            longest = longest.copy(first = prev, second = run)
        }
        run = 1
        prev = c
    }
    if (run > longest.second) {
        longest = longest.copy(first = prev, second = run)
    }
    return longest
}

/*
https://www.codewars.com/kata/59cfc000aeb2844d16000075/train/kotlin
Given a string, capitalize the letters that occupy even indexes and odd indexes separately, and return as shown below. Index 0 will be considered even.
 */
fun capitalize(text: String): List<String> {
    val isEven = {x: Int -> x % 2 == 0}
    val first = text.mapIndexed {i, c -> if (isEven(i)) c.uppercase() else c.lowercase() }
    val second = text.mapIndexed {i, c -> if (!isEven(i)) c.uppercase() else c.lowercase() }
    return listOf(first.joinToString(""), second.joinToString(""))
}
