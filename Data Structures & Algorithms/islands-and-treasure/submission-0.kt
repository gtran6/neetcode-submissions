class Solution {
    fun islandsAndTreasure(grid: Array<IntArray>) {
        val m = grid.size
        val n = grid[0].size
        val queue = ArrayDeque<Pair<Int, Int>>()

        for (i in 0 until m) {
            for (j in 0 until n) {
                if (grid[i][j] == 0) queue.addLast(i to j)
            }
        }

        while (queue.isNotEmpty()) {
            val (r, c) = queue.removeFirst()
            for ((dr, dc) in listOf(1 to 0, -1 to 0, 0 to 1, 0 to -1)) {
                val nr = r + dr
                val nc = c + dc

                if (nr < 0 || nr >= m || nc < 0 || nc >= n || grid[nr][nc] != Int.MAX_VALUE) continue
                grid[nr][nc] = grid[r][c] + 1
                queue.add(nr to nc)
            }
        }
    }
}
