class Solution {
    fun findRedundantConnection(edges: Array<IntArray>): IntArray {
        val n = edges.size
        val parent = IntArray(n + 1) { it }

        fun find(node: Int): Int {
            if (parent[node] != node) parent[node] = find(parent[node])
            return parent[node]
        }

        fun union(a: Int, b: Int): Boolean {
            val rootA = find(a)
            val rootB = find(b)
            if (rootA == rootB) return true
            parent[rootA] = rootB
            return false
        }

        for ((u, v) in edges) {
            if (union(u, v)) return intArrayOf(u, v)
        }
        return intArrayOf()
    }
}
