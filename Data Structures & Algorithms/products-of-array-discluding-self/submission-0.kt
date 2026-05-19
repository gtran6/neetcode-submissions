class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val n = nums.size
        val result = IntArray(n)
        for (i in nums.indices) {
            var product = 1
            for (j in nums.indices) {
                if (i != j) {
                    product *= nums[j]
                }
            }
            result[i] = product
        }
        return result
    }
}
