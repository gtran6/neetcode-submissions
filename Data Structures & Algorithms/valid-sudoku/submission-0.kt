class Solution {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val rows = Array(9) { HashSet<Char>() }
        val cols = Array(9) { HashSet<Char>() }
        val boxes = Array(9) { HashSet<Char>() }
        for (r in 0 until 9) {
            for (c in 0 until 9) {
                val cell = board[r][c]
                if (cell == '.') continue
                val boxId = (r / 3) * 3 + (c / 3)
                if (cell in rows[r] || cell in cols[c] || cell in boxes[boxId]) return false
                rows[r].add(cell)
                cols[c].add(cell)
                boxes[boxId].add(cell)
            }
        }
        return true
    }
}
