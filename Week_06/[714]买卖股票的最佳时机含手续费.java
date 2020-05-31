//给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。 
//
// 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。 
//
// 返回获得利润的最大值。 
//
// 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。 
//
// 示例 1: 
//
// 输入: prices = [1, 3, 2, 8, 4, 9], fee = 2
//输出: 8
//解释: 能够达到的最大利润:  
//在此处买入 prices[0] = 1
//在此处卖出 prices[3] = 8
//在此处买入 prices[4] = 4
//在此处卖出 prices[5] = 9
//总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8. 
//
// 注意: 
//
// 
// 0 < prices.length <= 50000. 
// 0 < prices[i] < 50000. 
// 0 <= fee < 50000. 
// 
// Related Topics 贪心算法 数组 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
/**
 5.29 第一遍
 - 思路：动态规划。这道题实际上还是 122 题的变种，即 k = inf。但是不同的是这里对于 k 的成本有了要求，即每一次买卖，都需要付出 fee。有两种做法，第一个是在第一个式子中减去 fee，第二个是在第二个式子中加上 fee，分别代表卖出股票的价格降低了 or 买入股票的价格升高了。
 - Recursive Cases One：
 1. dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i] - fee)
 2. dp[i][1] = max(dp[i-1][1], dp[i-1][1] - prices[i])
 3. 此时的 dp[i][1] 不能初始化为 Integer.MIN_VALUE，否则会出现数组越界错误
 - Recursive Cases Two:
 1. dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
 2. dp[i][1] = max(dp[i-1][1], dp[i-1][1] - prices[i] - fee)
 */
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int dp_i0 = 0, dp_i1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int tmp = dp_i0;
            dp_i0 = Math.max(dp_i0, dp_i1 + prices[i]);
            dp_i1 = Math.max(dp_i1, tmp - prices[i] - fee);
        }
        return dp_i0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
