package roman_to_integer

/**
 * @see https://leetcode.com/problems/roman-to-integer/
 */
fun main() {

}

private class Solution {
    fun romanToInt(s: String): Int {
        var result: Int = 0
        var lastChar: Int = 0
        s.forEach {
            if ((lastChar < it.toRomanInt())) {
                result -= lastChar * 2
            }
            result += it.toRomanInt()
            lastChar = it.toRomanInt()
        }
        return result
    }
}

private fun Char.toRomanInt(): Int {
    return romanMap[this] ?: throw IllegalArgumentException("Illegal char.")
}

private val romanMap = mapOf(
    'I' to 1,
    'V' to 5,
    'X' to 10,
    'L' to 50,
    'C' to 100,
    'D' to 500,
    'M' to 1000,
)