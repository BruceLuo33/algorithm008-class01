//给定一个二维网格和一个单词，找出该单词是否存在于网格中。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例: 
//
// board =
//[
//  ['A','B','C','E'],
//  ['S','F','C','S'],
//  ['A','D','E','E']
//]
//
//给定 word = "ABCCED", 返回 true
//给定 word = "SEE", 返回 true
//给定 word = "ABCB", 返回 false 
//
// 
//
// 提示： 
//
// 
// board 和 word 中只包含大写和小写英文字母。 
// 1 <= board.length <= 200 
// 1 <= board[i].length <= 200 
// 1 <= word.length <= 10^3 
// 
// Related Topics 数组 回溯算法


//leetcode submit region begin(Prohibit modification and deletion)
/**
 6.7 第一遍
 - 思路：dfs + 回溯。没有用 visited 矩阵来识别是否访问了某个元素，而是类似于岛屿问题，直接将访问过的元素更改，然后在回溯之后再改回来
 1. 将 word 转换为 charArray，方便进行下标访问；
 2. 从 board[0][0] 开始，进行 dfs，先将 board[i][j] 的元素保存，将其改为 '.'，然后往四个方向分别进行 dfs，如果 dfs == true，就 return true；
 3. 四个方向都 dfs 之后，进行回溯，board[i][j] = tmp；
 - 注意：如果采用 visited 数组的方式，就不能简单的 `if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != wordArray[len]) return false;`，这会造成数组越界，应该分别对每一种情况去 dfs，例如 `if (i > 1) {if (dfs(..., i - 1, j, ...)) return true;}`，分别对四种情况进行 dfs
 */
class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null) return false;
        int m = board.length, n = board[0].length;
        char[] wordArray = word.toCharArray();
        if (m * n < wordArray.length) return false;
        int len = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == wordArray[0]) {
                    if (dfs(board, i, j, wordArray, len)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, char[] wordArray, int len) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != wordArray[len]) return false;
        if (len == wordArray.length - 1) return true;
        char tmp = board[i][j];
        board[i][j] = '.';
        if (dfs(board, i, j + 1, wordArray, len + 1)) return true;
        else if (dfs(board, i + 1, j, wordArray, len + 1)) return true;
        else if (dfs(board, i - 1, j, wordArray, len + 1)) return true;
        else if (dfs(board, i, j - 1, wordArray, len + 1)) return true;
        board[i][j] = tmp;
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
