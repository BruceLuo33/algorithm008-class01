//给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。 
//
// 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。 
//
// 示例: 
//
// X X X X
//X O O X
//X X O X
//X O X X
// 
//
// 运行你的函数后，矩阵变为： 
//
// X X X X
//X X X X
//X X X X
//X O X X
// 
//
// 解释: 
//
// 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被
//填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。 
// Related Topics 深度优先搜索 广度优先搜索 并查集


//leetcode submit region begin(Prohibit modification and deletion)
/**
 6.4 第一遍
 - 思路：DFS。这道题思路和 200.岛屿数量 非常相似，具体而言：
 1. 先遍历四条边，然后和岛屿题一样，找到所有与边界上 `O` 相连的内部`O`，将其改为`'.'`
 2. 而后遍历整个区域，将所有的`'O'` 变成 `'X'`,所有的`'.'` 变为 `'O'`
 3. 在判断 `board[row][col]`是否合法的时候，不能仅仅只判断 row 和 col 值的大小，还要判断 `borad[row][col] == 'O' or not`，如果为否，则 return
 - 复杂度分析：O(M*N)
 */

class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        int m = board.length, n = board[0].length;
        // Find 'O' in the left and right
        for (int i = 0; i < m; i++) {
            dfs(board, i, 0);
            dfs(board, i, n - 1);
        }
        // Find 'O' in the top and bottom
        for (int j = 0; j < n; j++) {
            dfs(board, 0, j);
            dfs(board, m - 1, j);
        }
        // Recover the board:
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == '.') board[i][j] = 'O';
            }
        }
    }
    private void dfs(char[][] board, int row, int col) {
        if (!inArea(board, row, col)) return;
        board[row][col] = '.';
        dfs(board, row - 1, col);
        dfs(board, row + 1, col);
        dfs(board, row, col - 1);
        dfs(board, row, col + 1);

    }

    private boolean inArea(char[][] board, int row, int col) {
        if (row < 0 || col < 0 || row > board.length - 1 || col > board[0].length - 1 || board[row][col] != 'O')
            return false;
        else
            return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
