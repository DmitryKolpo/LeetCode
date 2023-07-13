package palindrom_number

/**
 * @see https://leetcode.com/problems/palindrome-number/
 * */
fun main() {

}

private class Solution {
    fun isPalindrome(x: Int): Boolean {
        val x = x.toString()
        val middleIndex = x.lastIndex / 2
        for (i in 0..middleIndex) {
            if (x[i] != x[x.lastIndex - i]) return false
        }
        return true
    }
}

private class ReadableSolution {
    fun isPalindrome(x: Int): Boolean {
        val a = x.toString()
        val b = x.toString().reversed()
        return a == b
    }
}