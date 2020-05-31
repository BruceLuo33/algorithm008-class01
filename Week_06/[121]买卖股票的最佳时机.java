//给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。 
//
// 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。 
//
// 注意：你不能在买入股票前卖出股票。 
//
// 
//
// 示例 1: 
//
// 输入: [7,1,5,3,6,4]
//输出: 5
//解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
//     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
// 
//
// 示例 2: 
//
// 输入: [7,6,4,3,1]
//输出: 0
//解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
// 
// Related Topics 数组 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
/**
 5.29 第一遍
 - 思路：动态规划。关键在于找到状态转移方程，而找这个方程，就需要明确有多少种状态。在这里，有三种状态，分别是：天数、买卖次数和是否买or卖。
 1. 天数 i 从 0 开始 循环到 n, `for (int i = 0, i < n; i++)`
 2. 买卖次数 j 从零开始，循环到 k，`for (int j = 0; j < k, j++)`
 3. 买卖是否发生，只有两种状态，因此用 {0, 1} 来分别表示。
 4. Base Cases：
 - dp[-1][j][0] = dp[i][0][0] = 0 (-1天表示股票市场还没开放，这时候在未持有 [0] 的状态下，盈利肯定是 0； 同样，任意一天 i 天，如果不能操作，那么 profit = 0)
 - dp[-1][j][1] = dp[i][0][1] = -inf (在 -1 天时，股票市场都没开放，就想进行买入操作是不可能的，用 -inf 来表示这种不可能；同理，任意一天如果都不允许进行任何操作，即 k = 0，那么肯定也是 -inf)
 5. Recursive Cases：
 - dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])，第 i 天如果没持有股票，要么就是前一天也没持有，或者前一天持有但是今天卖了，取二者较大值；
 - dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][1] - prices[i])，第 i 天如果持有股票，要么就是前一天也持有，要么就是前一天每持有但是今天买了，取二者较大值。k - 1 是因为执行了一次买入的操作。
 - 注意：i - 1 可能会出现数组越界的问题， 要提前判断
 - 复杂度分析：O（N），空间复杂度：O（N），可以提升为 O（1）
 */


class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int n = prices.length, k = 1;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (i - 1 == -1) {
                dp[i][0] = 0;
                // dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i])
                //          = Math.max(-inf, 0 - prices[i])
                //          = -prices[i]
                dp[i][1] = -prices[i];
                continue;
            }
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],  - prices[i]);
        }
        return Math.max(dp[n-1][0], dp[n-1][1]);
    }

    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int n = prices.length, k = 1;
        int dp_i0 = 0, dp_i1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            dp_i0 = Math.max(dp_i0, dp_i1 + prices[i]);
            dp_i1 = Math.max(dp_i1, -prices[i]);
        }
        return dp_i0;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
