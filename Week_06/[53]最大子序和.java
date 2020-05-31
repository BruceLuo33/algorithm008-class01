//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 示例: 
//
// 输入: [-2,1,-3,4,-1,2,1,-5,4],
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
// 
//
// 进阶: 
//
// 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。 
// Related Topics 数组 分治算法 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
/**
 5.25 第一遍，5.27 第二遍
 - 思路：动态规划。首先，一道题想要快速做出来，理解题意才是最重要的。对于这道题而言，我们需要找出一个连续的子序列，其和应该是所有的子序列最大的。
 1. 设置 ans，动态存储每一个子序列的最大值；
 2. 设置 sum，其代表的意思是在 n 之前的所有数的和，如果 sum 大于零，那么 sum + n 一定是递增的，反之，sum + n 将会递减，与我们的期望不符合；
 3. 所以，当 sum > 0 的时候，令 sum += n，而当 sum < 0 时，就舍弃掉以前的 sum，并重置为当前的 n
 4. 最后在每次循环的时候，ans 取 ans 与 sum 中的较大值。
 复杂度分析：O（N）
 */

class Solution {
    public int maxSubArray(int[] nums) {
        int ans = nums[0], sum = 0;
        for (int n : nums) {
            if (sum >= 0) {
                sum += n;
            } else {
                sum = n;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
