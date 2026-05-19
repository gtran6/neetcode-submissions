class Solution {
    fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
        val maxHeap = PriorityQueue<Pair<Int, IntArray>>(compareByDescending { it.first })
        for (point in points) {
            val dist = point[0] * point[0] + point[1] * point[1]
            if (maxHeap.size < k) {
                maxHeap.add(dist to point)
            } else if (dist < maxHeap.peek()!!.first) {
                maxHeap.poll()
                maxHeap.add(dist to point)
            }
        }
        return maxHeap.map { it.second }.toTypedArray()
    }
}
