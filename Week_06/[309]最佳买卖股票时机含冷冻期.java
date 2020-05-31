//给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。 
//
// 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）: 
//
// 
// 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
// 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。 
// 
//
// 示例: 
//
// 输入: [1,2,3,0,2]
//输出: 3 
//解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出] 
// Related Topics 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
/**
 5.29 第一遍
 - 思路：动态规划。和 122 题非常类似，不同的是多了一个冷冻期，即从 T+0 变成了 T+1 交易。解决方法也很简单，用一个变量存下前两天的价格就可以了。
 - Recursive Cases:
 1. dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i]); 出售股票没有 T+1，所以是 i - 1
 2. dp[i][1] = max(dp[i-1][1], dp[i-2][0] - prices[i]); 买入股票的操作，必须在卖出股票之后两天，所以是 i - 2
 3. tmp = dp_i0，代表的是 i-1 天的数值，在每一次 for 循环中，都是第 i 天的数值，循环完之后，就到了第 i + 1 天，如果将 save = tmp，即对于下一个循环而言，save 已经是 i - 1，即两天前的数值了，这样就达到了我们的要求。
 复杂度分析：O（N）
 */

class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int n = prices.length;
        int dp_i0 = 0, dp_i1 = Integer.MIN_VALUE;
        int save = 0;
        for (int i = 0; i < n; i++) {
            int tmp = dp_i0;
            dp_i0 = Math.max(dp_i0, dp_i1 + prices[i]);
            dp_i1 = Math.max(dp_i1, save - prices[i]);
            save = tmp;
        }
        return dp_i0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
