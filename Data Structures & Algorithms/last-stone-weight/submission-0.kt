class Solution {
    fun lastStoneWeight(stones: IntArray): Int {
        val maxHeap = PriorityQueue<Int>(reverseOrder())
        for (stone in stones) {
            maxHeap.add(stone)
        }
        while (maxHeap.size > 1) {
            val x = maxHeap.poll()
            val y = maxHeap.poll()
            if (x != y) maxHeap.add(abs(x - y))
        }
        return maxHeap.poll() ?: 0
    }
}
