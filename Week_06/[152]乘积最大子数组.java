//给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。 
//
// 
//
// 示例 1: 
//
// 输入: [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 输入: [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
// Related Topics 数组 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
/**
 5.25 第一遍，5.27 第二遍
 - 思路：动态规划。这道题和 53 题最大子序和很相似，但是不同之处在于，这里负数的存在，会影响最终的结果。
 1. 要求最大值，那么一定是比较前序的最大值和当前的数列的值，即 `Math.max(max * n, n)`；
 2. 但是，由于负数的存在，会令最大值的乘积变成最小的，因此还需要一个 min 变量，以处理出现负数的情况。
 复杂度分析：O（N）
 */

class Solution {
    public int maxProduct(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int max = 1, min = 1;
        for (int n : nums) {
            if (n < 0) {
                int tmp = max;
                max = min;
                min = tmp;
            }
            max = Math.max(max * n, n);
            min = Math.min(min * n, n);
            ans = Math.max(max, ans);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
