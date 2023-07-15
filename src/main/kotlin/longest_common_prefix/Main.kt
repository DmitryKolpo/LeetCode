package longest_common_prefix

fun main() {
    Solution().longestCommonPrefix(
        arrayOf("cir", "car")
    )
}

private class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.isEmpty()) return ""
        if (strs.size == 1) return strs[0]

        val sample = strs[0]
        val hashMap: HashMap<Int, Int> = hashMapOf()
        strs.forEach {
            it.forEachIndexed { index, c ->
                if (index > sample.lastIndex) return@forEach
                if (sample[index] != c) return@forEach

                hashMap[index] = hashMap[index]?.plus(1) ?: 1
            }
        }

        if (hashMap[0] != strs.size) return ""
        if (hashMap[sample.lastIndex] == strs.size) return sample
        (1..sample.lastIndex).forEach {
            if (hashMap[it] != strs.size) return sample.substring(0, it)
        }
        throw Exception("something goes wrong")
    }
}