class Solution {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val minHeap = PriorityQueue<Int>(k)
        for (num in nums) {
            if (minHeap.size < k) {
                minHeap.add(num)
            } else if (num > minHeap.peek()!!) {
                minHeap.poll()
                minHeap.add(num)
            }
        }
        return minHeap.peek()!!
    }
}
