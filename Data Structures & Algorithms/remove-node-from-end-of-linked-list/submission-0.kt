/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        var dummy = ListNode(0)
        dummy.next = head
        var slow = dummy
        var fast = dummy

        for (i in 0 until n) {
            fast = fast.next!!
        }

        while (fast.next != null) {
            slow = slow.next!!
            fast = fast.next!!
        }
        slow.next = slow?.next?.next
        return dummy.next
    }
}
