class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        if (strs.isEmpty()) return emptyList()
        val map = HashMap<String, MutableList<String>>()

        for (string in strs) {
            val key = string.toCharArray().sorted().joinToString("")
            map.getOrPut(key) { mutableListOf() }.add(string)
        }
        return map.values.toList()
    }
}
