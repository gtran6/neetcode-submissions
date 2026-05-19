class KthLargest(k: Int, nums: IntArray) {
    private val minHeap = PriorityQueue<Int>()
    private val k = k

    init {
        for (num in nums) {
            add(num)
        }
    }

    fun add(`val`: Int): Int {
        if (minHeap.size < k) {
            minHeap.add(`val`)
        } else if (`val` > minHeap.peek()!!) {
            minHeap.poll()
            minHeap.add(`val`)
        }
        return minHeap.peek()!!
    }
}
