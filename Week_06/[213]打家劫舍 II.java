//你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋
//装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。 
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。 
//
// 示例 1: 
//
// 输入: [2,3,2]
//输出: 3
//解释: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
// 
//
// 示例 2: 
//
// 输入: [1,2,3,1]
//输出: 4
//解释: 你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
// Related Topics 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
/**
 5.27 第一遍
 - 思路：动态规划。整体的解法和第一个打家劫舍相似，但是不同的地方在于多了一个对环形数组的判断。分析发现，整体抢劫的可能只有三种：
 1. 首尾都没有被抢；
 2. 抢了首个，最后一个没被抢；
 3. 第一个没被抢，最后一个被抢了；
 - 调整数组的range，来完成这三个可能性，最后的答案就会在这三个中选出。
 - 复杂度分析：O（N）
 */
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int n = nums.length;
        return Math.max(Math.max(helper(nums, 1, n - 2), helper(nums, 0, n - 2)), helper(nums, 1, n - 1));
        // return Math.max(helper(nums, 0, n - 2), helper(nums, 1, n - 1));
    }

    private int helper(int[] nums, int start, int end) {
        int prev = 0, curr = 0;
        for (int i = start; i <= end; i++) {
            int tmp = curr;
            curr = Math.max(prev + nums[i], tmp);
            prev = tmp;
        }
        return curr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
