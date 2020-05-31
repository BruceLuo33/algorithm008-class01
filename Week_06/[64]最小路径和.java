//给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。 
//
// 说明：每次只能向下或者向右移动一步。 
//
// 示例: 
//
// 输入:
//[
//  [1,3,1],
//  [1,5,1],
//  [4,2,1]
//]
//输出: 7
//解释: 因为路径 1→3→1→1→1 的总和最小。
// 
// Related Topics 数组 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
/**
 5.30 第一遍
 - 思路：动态规划。乍一看这道题和之前做的路径之和一样，不过这里求的是最小的路径，62 题求得是所有路径的可能。这里从左上角出发：
 1. 如果 `i == 0 && j == 0`，说明就是左上角顶点，令 dp[i][j] = grid[i][j]
 2. 如果不是，继续判断 `i == 0 ` 和 `j == 0`，此时因为 i - 1 和 j - 1 分别都数组越界了，所以需要额外判断
 3. 最后就是状态转移方程：dp[i][j] = grid[i][j] + Math.min(dp[i][j-1], dp[i-1][j]);
 - 复杂度分析：O（MN），空间复杂度：O（MN)
 */
class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                } else if (i == 0) {
                    dp[i][j] = grid[i][j] + dp[i][j-1];
                } else if (j == 0) {
                    dp[i][j] = grid[i][j] + dp[i-1][j];
                } else{
                    dp[i][j] = grid[i][j] + Math.min(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[m-1][n-1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
