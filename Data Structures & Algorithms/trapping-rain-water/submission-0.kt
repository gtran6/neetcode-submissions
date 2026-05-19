class Solution {
    fun trap(height: IntArray): Int {
        var left = 0
        var right = height.size - 1
        var maxLeft = height[left]
        var maxRight = height[right]
        var water = 0
        
        while (left < right) {
            if (maxLeft < maxRight) {
                left++
                maxLeft = maxOf(maxLeft, height[left])
                water += maxLeft - height[left]
            } else {
                right--
                maxRight = maxOf(maxRight, height[right])
                water += maxRight - height[right]
            }
        }
        return water
    }
}
