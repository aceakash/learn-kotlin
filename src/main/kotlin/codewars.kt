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
fun hero(bullets: Int, dragons: Int) : Boolean {
    return bullets >= 2*dragons
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