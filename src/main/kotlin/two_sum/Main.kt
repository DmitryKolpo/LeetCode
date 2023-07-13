package two_sum

/**
 * @see https://leetcode.com/problems/two-sum/
 * */
fun main() {
    val solution = Solution()
    val testCases = listOf(
        (intArrayOf(2, 7, 11, 15) to 9) to intArrayOf(0, 1),
        (intArrayOf(3, 2, 4) to 6) to intArrayOf(1, 2),
        (intArrayOf(2, 7, 11, 15) to 9) to intArrayOf(0, 1),
        (intArrayOf(Int.MAX_VALUE, 1, 2) to 3) to intArrayOf(1, 2),
        (intArrayOf(Int.MAX_VALUE, Int.MIN_VALUE, 1, 2) to 3) to intArrayOf(2, 3),
        (intArrayOf(Int.MAX_VALUE, Int.MIN_VALUE, 1, 2) to -1) to intArrayOf(0, 1),
        (intArrayOf(Int.MAX_VALUE, Int.MAX_VALUE, 0, -2) to -2) to intArrayOf(2, 3),
    )

    testCases.forEach {
        val input = it.first
        val actual = solution.twoSum(input.first, input.second)
        val expected = it.second
        println("actual=${actual.toList()}; expected=${expected.toList()}")
    }
}

private class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        for (i in 0 until nums.lastIndex) {
            for (j in i + 1..nums.lastIndex) {
                val firstNumber = nums[i].toLong()
                val secondNumber = nums[j].toLong()
                val success = firstNumber + secondNumber == target.toLong()
                if (success) return intArrayOf(i, j)
            }
        }
        throw Exception("There is no solution.")
    }
}

