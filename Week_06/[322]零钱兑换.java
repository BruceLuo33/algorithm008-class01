//给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回
// -1。 
//
// 
//
// 示例 1: 
//
// 输入: coins = [1, 2, 5], amount = 11
//输出: 3 
//解释: 11 = 5 + 5 + 1 
//
// 示例 2: 
//
// 输入: coins = [2], amount = 3
//输出: -1 
//
// 
//
// 说明: 
//你可以认为每种硬币的数量是无限的。 
// Related Topics 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
/**
 5.26 第一遍，5.27 第二遍
 - 思路：动态规划。考虑从最后开始思考，设置一个 amount + 1 长度的数组，每一个 dp[i] 的值都是从其值减去所有的 coin 的结果中的最小值：
 1. 例如，dp[11] = Math,min(dp[10], dp[6], dp[1])，coins = [1, 5, 10], amount = 11；
 2. 因为我们不确定 coins 中元素的个数，所以需要遍历 coins 中的所有元素，每次比较 dp[i] 与 dp[i - coin] + 1，并更新较小值为新的 dp[i]；
 3. 之所以要将 dp[i - coin] 的值加一，是因为 “- coin” 的这个操作就已经将状态回退了，例如当我们比较 `dp[11]` 与 `dp[10]` 的时候，dp[10] 就已经是减掉了一个零钱，所以需要将其加一再比较。
 - 复杂度分析：O（N*k）
 */
class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0) return -1;
        if (amount == 0) return 0;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, 1, dp.length, amount + 1);
        for (int i = 0; i < dp.length; i++) {
            for (int coin : coins) {
                if (i - coin < 0) continue;
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
