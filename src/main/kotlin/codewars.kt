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