class Solution {

    fun encode(strs: List<String>): String {
        val encode = StringBuilder()
        for (string in strs) {
            encode.append(string.length).append('#').append(string)
        }
        return encode.toString()
    }

    fun decode(str: String): List<String> {
        val result = mutableListOf<String>()
        var i = 0
        while (i < str.length) {
            val idx = str.indexOf('#', i)
            val length = str.substring(i, idx).toInt()
            val word = str.substring(idx + 1, idx + 1 + length)
            result.add(word)
            i = idx + 1 + length
        }
        return result
    }
}
