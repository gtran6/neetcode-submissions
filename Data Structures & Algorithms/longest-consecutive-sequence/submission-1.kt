class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        val set = nums.toHashSet()
        var currCount = 0
        var maxCount = 0
        for (num in nums) {
            if ((num - 1) !in set) {
                currCount = 1
                var curr = num
                while ((curr + 1) in set) {
                    currCount++
                    curr++
                }
                maxCount = maxOf(maxCount, currCount)
            }
        }
        return maxCount
    }
}
