//给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。 
//
// 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。 
//
// 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
//
// 
//
// 示例 1: 
//
// 输入: [7,1,5,3,6,4]
//输出: 7
//解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
//     随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
// 
//
// 示例 2: 
//
// 输入: [1,2,3,4,5]
//输出: 4
//解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
//     注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
//     因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
// 
//
// 示例 3: 
//
// 输入: [7,6,4,3,1]
//输出: 0
//解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。 
//
// 
//
// 提示： 
//
// 
// 1 <= prices.length <= 3 * 10 ^ 4 
// 0 <= prices[i] <= 10 ^ 4 
// 
// Related Topics 贪心算法 数组


//leetcode submit region begin(Prohibit modification and deletion)
/**
 5.15 第一遍，5.29 第二遍
 - 思路一：贪心算法。这是超哥课程上的例题，采用的算法就是低买高卖，求得累加最大值。
 - 思路二：动态规划。参考 121 题的笔记，三个参数 i、k、s，这里变化的是 k，从 121 题的 k = 1 变成了 k = inf。看起来有很大的变化但是实际上还是一样的思路。因为当 k -> inf 的时候，k = k - 1，所以实际上 k 也可以省略。
 1. Recursive cases:
 - dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
 - dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k][0] - prices[i])，这里最后一项是 k 而非 k - 1
 - 观察发现，两个式子中的 k 实际上都没有发生变化，所以可以省略不去管它
 2. Update Recursive cases:
 - dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
 - dp[i][1] = max(dp[i-1][1], dp[i-1][0] - prices[i])
 复杂度分析：O（N）
 */
class Solution {

    // Solution Two：DP
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int n = prices.length;
        int dp_i0 = 0, dp_i1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int tmp = dp_i0;
            dp_i0 = Math.max(dp_i0, dp_i1 +prices[i]);
            dp_i1 = Math.max(dp_i1, tmp - prices[i]);
        }
        return dp_i0;
    }

    // Solution One：贪心算法
    public int maxProfit(int[] prices) {
        int profit = 0;
        int len = prices.length;
        if (len == 0 || len == 1) return profit;
        int pos = 0;
        while (pos < len - 1) {
            int substract = prices[pos+1] - prices[pos];
            if (substract > 0) {
                profit += substract;
            }
            pos += 1;
        }
        return profit;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
