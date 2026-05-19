class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val map = HashMap<Int, Int>()
        val minHeap = PriorityQueue<Pair<Int, Int>>(compareBy {it.second} )
        for (num in nums) {
            map[num] = map.getOrDefault(num, 0) + 1
        }
        for ((num, freq) in map) {
            if (minHeap.size < k) {
                minHeap.add(num to freq)
            } else if (freq > minHeap.peek()!!.second) {
                minHeap.poll()
                minHeap.add(num to freq)
            }
        }
        return minHeap.map { it.first }.toIntArray()
    }
}
