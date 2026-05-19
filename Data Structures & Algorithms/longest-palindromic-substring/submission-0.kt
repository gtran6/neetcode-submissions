class Solution {
    fun longestPalindrome(s: String): String {
        var result = ""
        for (i in 0 until s.length){
            val odd = expandFromCentre(s, i, i)
            val even = expandFromCentre(s, i, i + 1)
            val len = maxOf(odd, even)
            if (len > result.length) {
                val start = i - (len - 1) / 2
                result = s.substring(start, start + len)
            }
        }
        return  result
    }
    fun expandFromCentre(s: String, left: Int, right: Int): Int {
        var l = left
        var r = right
        while (l >= 0 && r < s.length && s[l] == s[r]) {
            l--
            r++
        }
        return r - l - 1
    }
}
