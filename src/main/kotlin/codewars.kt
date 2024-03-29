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
fun longestRepetition(str: String): Pair<Char?, Int> {
    var longest:Pair<Char?, Int> = Pair(null, 0)
    str.forEachIndexed { index, c ->
        val start = str[index]
        val repeatedSeq = str.substring(index).takeWhile { it == start }
        if (repeatedSeq.length > longest.second) {
            longest = Pair(c, repeatedSeq.length)
        }
    }
    return longest}

/*
https://www.codewars.com/kata/59cfc000aeb2844d16000075/train/kotlin
Given a string, capitalize the letters that occupy even indexes and odd indexes separately, and return as shown below. Index 0 will be considered even.
 */
fun capitalize(text: String): List<String> {
    val isEven = { x: Int -> x % 2 == 0 }
    val first = text.mapIndexed { i, c -> if (isEven(i)) c.uppercase() else c.lowercase() }
    val second = text.mapIndexed { i, c -> if (!isEven(i)) c.uppercase() else c.lowercase() }
    return listOf(first.joinToString(""), second.joinToString(""))
}

/*
https://www.codewars.com/kata/54ff3102c1bad923760001f3
Return the number (count) of vowels in the given string.

We will consider a, e, i, o, u as vowels for this Kata (but not y).

The input string will only consist of lower case letters and/or spaces.
 */
fun getVowelCount(str: String): Int {
    return str.count { it in "aeiou" }
}

/*
https://www.codewars.com/kata/554b4ac871d6813a03000035

In this little assignment you are given a string of space separated numbers, and have to return the highest and lowest number.
Examples

highAndLow("1 2 3 4 5")  // return "5 1"
highAndLow("1 2 -3 4 5") // return "5 -3"
highAndLow("1 9 3 4 -5") // return "9 -5"

Notes

    All numbers are valid Int32, no need to validate them.
    There will always be at least one number in the input string.
    Output string must be two numbers separated by a single space, and highest number is first.
 */

fun highestAndLowest(numbers: String): String {
    val sorted = numbers
        .split(' ')
        .map { it.toInt() }
        .sortedDescending()

    return "${sorted.first()} ${sorted.last()}"
}

/*
https://www.codewars.com/kata/563b662a59afc2b5120000c6/kotlin

In a small town the population is p0 = 1000 at the beginning of a year.
The population regularly increases by 2 percent per year and moreover 50 new inhabitants per year come to live in the town.
How many years does the town need to see its population greater than or equal to p = 1200 inhabitants?

At the end of the first year there will be:
1000 + 1000 * 0.02 + 50 => 1070 inhabitants

At the end of the 2nd year there will be:
1070 + 1070 * 0.02 + 50 => 1141 inhabitants (** number of inhabitants is an integer **)

At the end of the 3rd year there will be:
1141 + 1141 * 0.02 + 50 => 1213

It will need 3 entire years.

More generally given parameters:

p0, percent, aug (inhabitants coming or leaving each year), p (population to equal or surpass)

the function nb_year should return n number of entire years needed to get a population greater or equal to p.

aug is an integer, percent a positive or null floating number, p0 and p are positive integers (> 0)

Examples:
nb_year(1500, 5, 100, 5000) -> 15
nb_year(1500000, 2.5, 10000, 2000000) -> 10

*/

fun growthOfPopulation(pp0: Int, percent: Double, aug: Int, p: Int): Int {
    var curr = pp0
    var yearsElapsed = 0
    while (curr < p) {
        val newPopulation: Double = curr + (curr * percent * 0.01) + aug
        curr = newPopulation.toInt()
        yearsElapsed++
    }
    return yearsElapsed
}

/*
https://www.codewars.com/kata/5bd00c99dbc73908bb00057a

In this kata you will be given a random string of letters and tasked with returning them as a string of comma-separated sequences sorted alphabetically, with each sequence starting with an uppercase character followed by n-1 lowercase characters, where n is the letter's alphabet position 1-26.
Example

alphaSeq("ZpglnRxqenU") -> "Eeeee,Ggggggg,Llllllllllll,Nnnnnnnnnnnnnn,Nnnnnnnnnnnnnn,Pppppppppppppppp,Qqqqqqqqqqqqqqqqq,Rrrrrrrrrrrrrrrrrr,Uuuuuuuuuuuuuuuuuuuuu,Xxxxxxxxxxxxxxxxxxxxxxxx,Zzzzzzzzzzzzzzzzzzzzzzzzzz"

Technical Details

    The string will include only letters.
    The first letter of each sequence is uppercase followed by n-1 lowercase.
    Each sequence is separated with a comma.
    Return value needs to be a string.
 */
fun alphabeticalSequence(str: String): String {
    val letterToNumber = { letter: Char -> letter.toString().lowercase().first() - 'a' }

    return str.lowercase().toCharArray().sorted()
        .map { it.uppercase() + it.toString().repeat(letterToNumber(it)) }
        .joinToString(",")
}

/*
https://www.codewars.com/kata/56747fd5cb988479af000028

You are going to be given a word. Your job is to return the middle character of the word. If the word's length is odd, return the middle character. If the word's length is even, return the middle 2 characters.
 */

fun getMiddleCharacter(word: String): String {
    val start = (word.length - 1) / 2
    return word.substring(start, word.length - start)
}