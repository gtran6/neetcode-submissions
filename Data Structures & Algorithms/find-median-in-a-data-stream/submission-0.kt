class MedianFinder {
    val minHeap = PriorityQueue<Int>()
    val maxHeap = PriorityQueue<Int>(reverseOrder())

    fun addNum(num: Int) {
        if (maxHeap.isEmpty() || num <= maxHeap.peek()!!) {
            maxHeap.add(num)
        } else {
            minHeap.add(num)
        }
        if (maxHeap.size > minHeap.size + 1) {
            minHeap.add(maxHeap.poll()!!)
        }
        if (minHeap.size > maxHeap.size) {
            maxHeap.add(minHeap.poll()!!)
        }
    }

    fun findMedian(): Double {
        return if (minHeap.size == maxHeap.size) (maxHeap.peek()!!.toDouble() + minHeap.peek()!!.toDouble()) / 2.0
        else maxHeap.peek()!!.toDouble()
    }
}
