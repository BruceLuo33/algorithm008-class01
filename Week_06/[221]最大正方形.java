//在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。 
//
// 示例: 
//
// 输入: 
//
//1 0 1 0 0
//1 0 1 1 1
//1 1 1 1 1
//1 0 0 1 0
//
//输出: 4 
// Related Topics 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
/**
 5.30 第一遍
 - 思路：动态规划。从右下角开始思考，如果存在边长 >= 2 的正方形，那么从右下角开始，它的左、上、左上三个位置的小正方形以性都是另一个正方形的右下角。那么最终的正方形的范围，就是这三个位置的正方形边长中的最小值。否则的话，大的正方形就会出现缺角，也就不是正方形了。
 1. dp[i][j] = 1 + Math.min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]);
 2. 为了减少对于边界条件的判断，将 dp 数组的大小设置为 `dp[m+1][n+1]`，并且从 i/j = 1 开始进行；
 3. 不能用 64 题那种分别判断 `i == 0 && j == 0, else if (i == 0), else if (j == 0)` 的方式，因为我们最终的目的是找到一个正方形，那么就要保证上、左、左上三个位置都要有格子，但是这种判断方式显然不能达成我们的目标。
 复杂度分析：O（MN)
 */

class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m+1][n+1];
        int ans = 0;
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (matrix[i-1][j-1] == '1') {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j])) + 1;
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }
        return ans*ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
