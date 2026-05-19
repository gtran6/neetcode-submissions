class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val freqMap = HashMap<Int, Int>()
        for (num in nums) {
            freqMap[num] = freqMap.getOrDefault(num, 0) + 1
        }
        val minHeap = PriorityQueue<Pair<Int, Int>>( compareBy{it.first} )
        for ((num, freq) in freqMap) {
            if (minHeap.size < k) {
                minHeap.add(freq to num)
            } else if (freq > minHeap.peek()!!.first) {
                minHeap.poll()
                minHeap.add(freq to num)
            }
        }
        return minHeap.map {it.second}.toIntArray()
    }
}
