class Solution {
    fun countComponents(n: Int, edges: Array<IntArray>): Int {
        var count = n
        val parent = IntArray(n) { it }
        val rank = IntArray(n) { 0 }

        fun find(x: Int): Int {
            if (parent[x] != x) parent[x] = find(parent[x])
            return parent[x]
        }

        fun union(x: Int, y: Int): Boolean {
            val px = find(x)
            val py = find(y)
            if (px == py) return false
            if (rank[px] >= rank[py]) parent[py] = px
            else parent[px] = py
            if (rank[px] == rank[py]) rank[px]++
            return true
        }

        for ((u, v) in edges) {
            if (union(u, v)) count--
        }
        return count
    }
}
