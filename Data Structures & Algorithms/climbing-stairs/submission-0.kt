class Solution {
    fun climbStairs(n: Int): Int {
        if (n == 1) return 1
        if (n == 2) return 2
        var a = 1
        var b = 2
        repeat(n - 2) {
            val next = a + b
            a = b
            b = next
        }
        return b
    }
}
