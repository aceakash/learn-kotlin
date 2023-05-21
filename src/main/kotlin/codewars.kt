/*
https://www.codewars.com/kata/57eae20f5500ad98e50002c5/train/kotlin
Write a function that removes the spaces from the string, then return the resultant string.
 */
fun noSpace(x: String): String {
//    return x.replace(" ", "")
    return x.filterNot { it.isWhitespace() }
}