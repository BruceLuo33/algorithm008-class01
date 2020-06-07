//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 
//
// 上图为 8 皇后问题的一种解法。 
//
// 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。 
//
// 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 示例: 
//
// 输入: 4
//输出: [
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//解释: 4 皇后问题存在两个不同的解法。
// 
//
// 
//
// 提示： 
//
// 
// 皇后，是国际象棋中的棋子，意味着国王的妻子。皇后只做一件事，那就是“吃子”。当她遇见可以吃的棋子时，就迅速冲上去吃掉棋子。当然，她横、竖、斜都可走一或七步
//，可进可退。（引用自 百度百科 - 皇后 ） 
// 
// Related Topics 回溯算法


//leetcode submit region begin(Prohibit modification and deletion)
/**
 5.9 第一遍，6.3 第二遍
 思路：回溯。模板和 46 题很相似，不同的地方在于剪枝函数的设置。
 注意：剪枝函数中，我们需要排除同一列是否有其他皇后、右上方、左上方是否有皇后。不用搜寻其他方向的原因在于，我们的放置 Q 是从左上角开始的，意味着 isValid 的搜寻也只需要扫描已经放置了 Q 的地方。
 注意：在 isValid 函数中，只需进行列的搜索，因为主函数里面，row就已经是个变量，这里只要改变 col 就可以了
 */
class Solution {

    List<List<String>> ans = new LinkedList<>();

    public List<List<String>> solveNQueens(int n) {
        if (n <= 0) return ans;
        char[][] board = new char[n][n];
        for (char[] chars : board) {
            Arrays.fill(chars, '.');
        }
        backtrack(board, 0);
        return ans;
    }

    private void backtrack(char[][] board, int row) {
        if (row == board.length) {
            ans.add(charToString(board));
            return;
        }
        int n = board[row].length;
        for (int col = 0; col < n; col++) {
            if (!isValid(board, row, col)) continue;
            board[row][col] = 'Q';
            backtrack(board, row + 1);
            board[row][col] = '.';
        }
    }

    private List<String> charToString(char[][] array) {
        List<String> result = new LinkedList<>();
        for (char[] chars : array) {
            result.add(String.valueOf(chars));
        }
        return result;
    }

    private boolean isValid(char[][] board, int row, int col) {
        int n = board.length;
        // 判断同一列是否有 Q
        for (int i = 0; i < n; i++) {
            if (board[i][col] == 'Q') return false;
        }
        // 左上方
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }
        // 右上方
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }
        return true;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
