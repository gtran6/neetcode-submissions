class Solution {
    fun rob(nums: IntArray): Int {
        if (nums.size == 1) return nums[0]
        var a = nums[0]
        var b = maxOf(nums[0], nums[1])
        for (i in 2 until nums.size) {
            val tmp = maxOf(nums[i] + a, b)
            a = b
            b = tmp
        }
        return b
    }
}
