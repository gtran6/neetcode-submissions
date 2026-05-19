class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) return false
        val freq = IntArray(26)
        for (c in s) {
            freq[c - 'a']++
        }
        for (c in t) {
            freq[c - 'a']--
        }
        return freq.all { it == 0 }
    }
}
