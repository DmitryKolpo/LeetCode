package valid_parantheses

import java.util.*

/**
 * @see [https://leetcode.com/problems/valid-parentheses/]
 */
fun main() {
    val solution = Solution()

    println(solution.isValid("()"))
    println(solution.isValid("()[]{}"))
    println(!solution.isValid("(}"))
    println(!solution.isValid("}{"))
    println(!solution.isValid("([)]"))
}

private class Solution {
    fun isValid(s: String): Boolean {
        val stack: Stack<Char> = Stack()
        s.forEach {
            if (!validInputs.contains(it)) throw IllegalArgumentException("Char $it is not allowed in input")

            when (it) {
                in opening -> stack.push(it)
                in closing -> {
                    if (stack.isEmpty()) return false
                    if (stack.pop() != it.opposite()) return false
                }
            }
        }
        return stack.isEmpty()
    }
}

private fun Char.opposite(): Char {
    if (this == '(') return ')'
    if (this == ')') return '('

    if (this == '{') return '}'
    if (this == '}') return '{'

    if (this == '[') return ']'
    if (this == ']') return '['
    throw IllegalArgumentException()
}

private val opening = listOf(
    '(',
    '{',
    '[',
)

private val closing = listOf(
    ')',
    '}',
    ']',
)

private val validInputs = opening + closing
