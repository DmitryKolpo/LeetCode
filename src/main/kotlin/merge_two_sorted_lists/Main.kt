package merge_two_sorted_lists

/**
 * @see [https://leetcode.com/problems/merge-two-sorted-lists/]
 */
fun main() {

}

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
private class Solution {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        if (list1 == null) return list2
        if (list2 == null) return list1

        var localList1 = list1
        var localList2 = list2
        val result: ListNode = ListNode(0)
        var localResultRef: ListNode = result
        while (localList1 != null && localList2 != null) {
            localResultRef.next = refOfMinVal(localList1, localList2)
            if (localList1.`val` <= localList2.`val`) {
                localList1 = localList1.next
            } else {
                localList2 = localList2.next
            }
            localResultRef = localResultRef.next!!
        }
        if (localList1 == null) localResultRef.next = localList2
        if (localList2 == null) localResultRef.next = localList1

        return result.next
    }
}

private fun refOfMinVal(list1: ListNode, list2: ListNode): ListNode {
    return if (list1.`val` <= list2.`val`) list1 else list2
}

private class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

