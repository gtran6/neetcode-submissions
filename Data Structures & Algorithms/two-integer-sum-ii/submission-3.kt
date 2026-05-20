class Solution {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        for (i in numbers.indices) {
            var left = i + 1
            var right = numbers.size - 1
            val remain = target - numbers[i]
            while (left <= right) {
                val mid = left + (right - left) / 2
                when {
                    numbers[mid] == remain -> return intArrayOf(i + 1, mid + 1)
                    numbers[mid] > remain -> right = mid - 1
                    else -> left = mid + 1
                }
            }
        }
        return intArrayOf()
    }
}
