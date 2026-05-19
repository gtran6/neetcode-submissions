class Solution {
    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        val adj = Array(numCourses) { mutableListOf<Int>() }
        val inDegree = IntArray(numCourses)
        for ((a, b) in prerequisites) {
            adj[b].add(a)
            inDegree[a]++
        }
        val queue = ArrayDeque<Int>()
        for (course in 0 until numCourses) {
            if (inDegree[course] == 0) queue.addLast(course)
        }
        val result = mutableListOf<Int>()

        while (queue.isNotEmpty()) {
            val course = queue.removeFirst()
            result.add(course)
            for (neighbor in adj[course]) {
                inDegree[neighbor]--
                if (inDegree[neighbor] == 0) queue.addLast(neighbor)
            }
        }
        return if (result.size == numCourses) result.toIntArray() else intArrayOf()
    }
}
