//给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。 
//
// 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。 
//
// 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
//
// 示例 1: 
//
// 输入: [2,4,1], k = 2
//输出: 2
//解释: 在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
// 
//
// 示例 2: 
//
// 输入: [3,2,6,5,0,3], k = 2
//输出: 7
//解释: 在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
//     随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 
//。
// 
// Related Topics 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
/**
 5.29 第一遍
 - 思路：动态规划。这道题和 123 比较相似，不同的是 k 从 2 变成了任意整数。需要注意的是，k 要考虑两个状态：
 1. k <= n/2，此时的 k 是有效的，因为股票想要有涨跌，当天买入卖出是不会有盈亏变化的，所以至少需要 2 天才能体现。如果交易次数大于了 n/2，那么可以将 k 视为 inf
 2. k > n/2，直接用 122 的方法。k = inf
 3. 注意对于数组的初始化，要在 k 值得判断之后，否则因为 k 太大了，数组会无法创建。
 复杂度分析：O（NK)
 */
class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length, m = 2;
        if (k > n/2) {
            return maxProfitInfiniteK(prices);
        }
        int[][][] dp = new int[n][k + 1][2];
        for ( int i = 0; i < n; i++) {
            for (int j = k; j > 0; j--) {
                if (i - 1 == -1) {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = -prices[i];
                    continue;
                }
                dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i-1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j-1][0] - prices[i]);

            }
        }
        return dp[n-1][k][0];
    }
    private int maxProfitInfiniteK(int[] prices) {
        int n = prices.length;
        int dp_i0 = 0, dp_i1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int tmp = dp_i0;
            dp_i0 = Math.max(dp_i0, dp_i1 + prices[i]);
            dp_i1 = Math.max(dp_i1, tmp - prices[i]);
        }
        return dp_i0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
