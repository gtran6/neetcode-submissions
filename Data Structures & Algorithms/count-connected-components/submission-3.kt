class Solution {
    fun countComponents(n: Int, edges: Array<IntArray>): Int {
        val parent = IntArray(n) { it }
        var count = n

        fun find(node: Int): Int {
            if (parent[node] != node) parent[node] = find(parent[node])
            return parent[node]
        }

        fun union(a: Int, b: Int): Boolean {
            val rootA = find(a)
            val rootB = find(b)
            if (rootA == rootB) return true
            parent[rootA] = rootB
            count--
            return false
        }

        for ((u, v) in edges) {
            union(u, v)
        }
        return count
    }
}
