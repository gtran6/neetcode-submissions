class Solution {
    fun orangesRotting(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size
        val queue = ArrayDeque<Pair<Int, Int>>()
        var freshCount = 0
        var minutes = 0

        for (i in 0 until m) {
            for (j in 0 until n) {
                when (grid[i][j]) {
                    1 -> freshCount++
                    2 -> queue.addLast(i to j)
                }
            }
        }
        if (freshCount == 0) return 0

        while (queue.isNotEmpty()) {
            repeat(queue.size) {
                val (r, c) = queue.removeFirst()
                for ((dr, dc) in listOf(0 to 1, 0 to -1, 1 to 0, -1 to 0)) {
                    val nr = dr + r
                    val nc = dc + c

                    if (nr < 0 || nr >= m || nc < 0 || nc >= n || grid[nr][nc] != 1) continue
                    grid[nr][nc] = 2
                    freshCount--
                    queue.addLast(nr to nc)
                }
            }
            minutes++
        }
        return if (freshCount == 0) minutes - 1 else -1
    }
}
