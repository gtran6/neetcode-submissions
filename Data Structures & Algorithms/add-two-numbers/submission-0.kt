/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var dummy = ListNode(0)
        var cur = dummy
        var p1 = l1
        var p2 = l2
        var carry = 0

        while (p1 != null || p2 != null || carry != 0) {
            val sum = (p1?.`val` ?: 0) + (p2?.`val` ?: 0) + carry
            cur.next = ListNode(sum % 10)
            carry = sum / 10
            p1 = p1?.next
            p2 = p2?.next
            cur = cur.next!!
        }
        return dummy.next
    }
}
