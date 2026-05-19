/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun reorderList(head: ListNode?): Unit {
        var slow = head
        var fast = head
        
        while (fast != null && fast.next != null) {
            slow = slow?.next
            fast = fast?.next?.next
        }

        var prev: ListNode? = null
        var cur = slow!!

        while (cur.next != null) {
            val tmp = cur?.next?.next
            cur?.next?.next = prev
            prev = cur.next!!
            cur.next = tmp
        }

        var first = head
        var second = prev

        while (first != null && second != null) {
            val nextFirst = first.next
            val nextSecond = second.next
            first.next = second
            second.next = nextFirst
            first = nextFirst
            second = nextSecond
        }
    }
}
