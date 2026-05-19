/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun reverseList(head: ListNode?): ListNode? {
        var prev: ListNode? = null
        var cur = head
        var next = head?.next

        while (cur != null) {
            next = cur.next
            cur.next = prev
            prev = cur
            cur = next
        }
        return prev
    }
}
