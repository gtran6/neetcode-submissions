class Solution {
    fun validTree(n: Int, edges: Array<IntArray>): Boolean {
        if (edges.size != n - 1) return false
        val adj = Array(n) { mutableListOf<Int>() }
        for ((a, b) in edges) {
            adj[b].add(a)
            adj[a].add(b)
        }
        val visited = HashSet<Int>()

        fun dfs(node: Int) {
            visited.add(node)
            for (edge in adj[node]){
                if (edge !in visited) dfs(edge)
            }
        } 
        dfs(0)
        
        return visited.size == n
    }
}
